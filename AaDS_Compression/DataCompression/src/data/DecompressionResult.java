package data;

/**
 * Created by Rafał on 2017-06-01.
 */
public class DecompressionResult {
    private String[] splitLine;

    public void adaptLine(String line){
        this.splitLine = line.split("\\s+");
    }
    public char getChar(){
        return splitLine[1].charAt(0);
    }
    public String getCharAsString(){
        return String.valueOf(getChar());
    }

    public int getLength(){
        return splitLine.length;
    }
    public int getMatchLength(){
        return Integer.valueOf(splitLine[2]);
    }
    public int getOffsetValue(){
        return Integer.valueOf(splitLine[1]);
    }



}
