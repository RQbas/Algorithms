package algorithm;

import data.CompressionResult;
import file.FileReaderHandler;
import file.FileWriterHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Compression implements Parameters{
    FileReaderHandler fR;
    FileWriterHandler fW;
    ArrayList<Character> actualLine = new ArrayList<Character>();
    ArrayList<Character> dictionaryPart = new ArrayList<Character>();
    ArrayList<Character> bufforPart = new ArrayList<Character>();
    CompressionResult result = new CompressionResult();
    CompressionRate rate;
    int doneShifts = 0;
    int minEncodedLength;



    public Compression(int minEncodedLength) throws IOException {
        this.minEncodedLength = minEncodedLength;
        setFileHandlers();

       for(int i=0; i<fR.getLineNumber(); i++) {
           rewriteLine();

           fillDictionaryPart();
           fillBufforPart();
           saveFirstSymbol();
           while(bufforPart.size() != 0) {
               result = findSubsequence();
               shiftBufforPart(result.getLength(), doneShifts);
               shiftDictionaryPart(result.getLength(), doneShifts);
               doneShifts += result.getLength();
           }
            cleanLineData();
        }
           closeFileHandlers();
        rate = new CompressionRate();
    }

    public void shiftBufforPart(int shiftElements, int doneShifts){
        try {
            for (int i = bufforSize; i < bufforSize + shiftElements; i++)
                bufforPart.add(actualLine.get(doneShifts + dictonarySize + i));
        }catch(Exception outOfIndex){

        }
        for(int i=0; i<shiftElements; i++)
           bufforPart.remove(0);
    }
    public void shiftDictionaryPart(int shiftElements, int doneShifts){
        for(int i=0; i<shiftElements; i++)
            dictionaryPart.add(actualLine.get(doneShifts+dictonarySize+i));
        for(int i=0; i<shiftElements; i++)
            dictionaryPart.remove(0);
    }

    public void rewriteLine() throws IOException {
        String actualLine = fR.getLine();

        for (char c : actualLine.toCharArray())
            this.actualLine.add(c);

        char firstChar = this.actualLine.get(0);

        for(int i=0; i<dictonarySize; i++)
            this.actualLine.add(0, firstChar);
    }
    public void saveFirstSymbol() throws IOException {
        fW.writeCompression(bufforPart.get(0).toString());
    }

    public void fillDictionaryPart(){
     for(int i=0; i<dictonarySize; i++)
         dictionaryPart.add(actualLine.get(i));
    }

    public void fillBufforPart(){
        for(int i=dictonarySize; i<dictonarySize+bufforSize; i++)
            bufforPart.add(actualLine.get(i));
    }

    public CompressionResult findSubsequence() throws IOException {
        StringBuffer dictionary = new StringBuffer();
        StringBuffer buffor= new StringBuffer();
        CompressionResult result = new CompressionResult();

        for(char c: dictionaryPart)
            dictionary.append(c);

        for(char c: bufforPart){
            buffor.append(c);
                if(isSubsequence(dictionary.toString(), buffor.toString()))
                    result.setSubsequence(buffor.toString());
        }

            if(!result.isSubsequenceFound()){
            result.subsequenceNotFound(bufforPart.get(0).toString());
                fW.writeCompression(result.toStringNotFound());
            }else {
                result.subsequenceFound(dictionary.toString());
                if (result.getLength() >= minEncodedLength) {
                    fW.writeCompression(result.toStringFound());
                } else {
                    fW.writeCompression(result.toStringNotFound());
                }
            }
        return result;
    }

    public boolean isSubsequence(String string, String substring) {
        int index = 0;
        for (char character : substring.toCharArray()) {
            index = string.indexOf(character, index);
            if (index <0)
                return false;
        }

        return true;
    }

    public void cleanLineData(){
        actualLine.removeAll(actualLine);
        bufforPart.removeAll(bufforPart);
        dictionaryPart.removeAll(dictionaryPart);
        doneShifts=0;
    }

    public void setFileHandlers() throws IOException {
            fR =FileReaderHandler.getInstanceInput();
            fW = FileWriterHandler.getInstanceOutput();
        }
    public void closeFileHandlers() throws IOException {
        fR.closeFileReader();
        fW.closeFileWriter();
    }

    public void displayList(List<Character> list){
        for (char c : list)
            System.out.print(c + " ");
        System.out.println("");

    }
}
