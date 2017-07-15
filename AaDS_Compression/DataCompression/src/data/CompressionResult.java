package data;

/**
 * Created by Rafał on 2017-05-30.
 */
public class CompressionResult {
    private String subsequence;
    private int index;
    private int length;
    private int flag;

    public void subsequenceNotFound(String subsequence){
        this.subsequence = subsequence ;
        length = 1;
        index = 0;
        flag = 1;
    }

    public String toStringFound(){
        return flag+" "+index+" "+length;
    }
    public String toStringNotFound(){
        return  flag+" "+subsequence;
    }
    public boolean isSubsequenceFound(){
        boolean isSubsequenceFound = false;
        if(subsequence !=null)
            isSubsequenceFound = true;
        return isSubsequenceFound;
    }
    public int getIndex(){
        return index;
    }
    public int getLength(){
        return length;
    }
    public String getSubsequence(){
        return subsequence;
    }
    public int getFlag(){
        return flag;
    }

    public void subsequenceFound(String dictionary) {
        flag = 0;
        length = subsequence.length();
        index = dictionary.indexOf(subsequence);
    }
    public void setSubsequence(String subsequence){
        this.subsequence = subsequence;
    }
}
