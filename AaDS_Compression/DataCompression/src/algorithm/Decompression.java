package algorithm;

import data.CompressionResult;
import data.DecompressionResult;
import file.FileReaderHandler;
import file.FileWriterHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Rafał on 2017-05-29.
 */
public class Decompression implements Parameters{
    FileReaderHandler fR;
    FileWriterHandler fW;
    ArrayList<Character> bufforPart = new ArrayList<Character>();
    DecompressionResult result = new DecompressionResult();
    Character firstChar;

    public Decompression() throws IOException {
        setFileHandlers();

        rewriteFirstLine();
        fillBufforPart();

        for(int i=0; i<fR.getLineNumber()-1; i++)
            decompressLine();

        closeFileHandlers();
    }
    public void decompressLine() throws IOException {
        result.adaptLine(fR.getLine());
            if(result.getLength()==1){
                bufforPart.add(' ');
                shiftBufforPart(1);
                fW.writeDecompression(" ");
            }
            if(result.getLength() ==2 ){
                bufforPart.add(result.getChar());
                shiftBufforPart(1);
                fW.writeDecompression(result.getCharAsString());
            }
            if(result.getLength() ==3){
                for(int i=0; i<result.getMatchLength(); i++){
                    fW.writeDecompression(bufforPart.get(result.getOffsetValue()).toString());
                    bufforPart.add(bufforPart.get(result.getOffsetValue()));
                    shiftBufforPart(1);
                }
            }
    }

    public void shiftBufforPart(int shiftElements) {
        for (int i = 0; i < shiftElements; i++)
            bufforPart.remove(0);
    }

    public void fillBufforPart(){
        for(int i=0; i<dictonarySize; i++)
            bufforPart.add(firstChar);
    }

    public void rewriteFirstLine() throws IOException {
        String actualLine = fR.getLine();
        try{
            firstChar = actualLine.charAt(0);
        }catch(Exception wrongFirstChar){
            System.out.println("Problem with ");
        }
    }

    public void setFileHandlers() throws IOException {
        fR = FileReaderHandler.getInstanceInput();
        fW = FileWriterHandler.getInstanceBinaryOutput();
    }
    public void closeFileHandlers() throws IOException {
        fR.closeFileReader();
        fW.closeFileWriter();
    }
}
