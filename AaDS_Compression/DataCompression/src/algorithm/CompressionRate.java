package algorithm;

import file.FileReaderHandler;
import file.FileWriterHandler;

import java.io.IOException;

/**
 * Created by Rafał on 2017-06-02.
 */
public class CompressionRate implements Parameters
{
    FileReaderHandler fR;
    FileWriterHandler fW;
    String[] splitLine;
    int inputSize;
    int outputSize;

    public CompressionRate() throws IOException {
        fR = FileReaderHandler.getInstanceInput();
        fW = FileWriterHandler.getInstanceBinaryOutput();
        measureInputSize();
        fR = FileReaderHandler.getInstanceOutput();
        measureOutputSize();
        displayCompressionRate();
        fW.closeFileWriter();
    }
    private void displayCompressionRate(){
        System.out.println("Compression Rate: "+ (float) (100*(8*inputSize-outputSize))/(8*inputSize)+"%");
    }
    private void measureOutputSize() throws IOException {
        String line;
        readFirstLetter();
        for (int i = 0; i < fR.getLineNumber()-1; i++) {
            line = fR.getLine();
            splitLine = line.split("\\s+");

            countBitsInOutput(splitLine);
            transformOutputToBinary(splitLine);
        }
        System.out.println("Output size:" + outputSize/8 + "B ->" +  outputSize + "b");
    }
    private void transformOutputToBinary(String[] splitLine) throws IOException {
        StringBuffer line = new StringBuffer();

        line.append(splitLine[0].toString());
        if(splitLine.length ==1){
            line.append(Integer.toBinaryString(32));
            fW.write(line.toString());
        }
        if(splitLine.length ==2){
            int charASCII = Integer.valueOf(splitLine[1].charAt(0));
            line.append(Integer.toBinaryString(charASCII));
            fW.write(line.toString());
        }
        if(splitLine.length==3) {
            int offset = Integer.valueOf(splitLine[1]);
            line.append(String.format("%"+dictonarySize+"s", Integer.toBinaryString(offset)).replace(" ", "0"));
            int length = Integer.valueOf(splitLine[2]);
            line.append(Integer.toBinaryString(length));
            fW.write(line.toString());
        }
        fW.writeNewLine();
    }
    private void countBitsInOutput(String[]  splitLine){
        outputSize+=1; //flag size;

        if(splitLine.length ==1)
            outputSize+=8; //spacebar found;

        if(splitLine.length ==2)
            outputSize +=8; //char not found
        if(splitLine.length==3)
        {
            outputSize += Integer.toBinaryString(dictonarySize).length();
            outputSize += converseLengthToBinaryBitNumber(splitLine[2]);
        }
    }
    private int converseLengthToBinaryBitNumber(String line){
            Integer lengthValue = Integer.valueOf(line);
            String binaryLengthValue = Integer.toBinaryString(lengthValue.intValue());
            return binaryLengthValue.length();
    }
    private void readFirstLetter() throws IOException {
        fR.getLine(); //Get first letter
        outputSize+=8;
    }
    private void measureInputSize() throws IOException {
        String line;
        for(int i=0; i<fR.getLineNumber(); i++){
            line = fR.getLine();
            inputSize+=  line.toCharArray().length;
        }
        System.out.println("Input size:" +inputSize+"B ->"+8*inputSize +"b" );
    }


}
