package application;

import bubble.*;
import insertion.SortInsertion1;
import insertion.SortInsertion2;
import selection.SortSelection;

public class AlgorithmCore extends BasicOperations{
    public static int arraySize;

    
    
    public AlgorithmCore(int size){
        setSize(size);
        createArrays();
        fillWithRandomNumber(numberArray);
        fillWithRandomString(stringArray);


        new SortBubble1(  stringArray);
        new SortBubble2(  stringArray);
        new SortBubble3( stringArray);
        new SortSelection( stringArray);
        new SortInsertion1( stringArray);
        new SortInsertion2( stringArray);


    }
    
    public void setSize(int size){
        this.arraySize = size;
    }
    
    void createArrays(){
        this.numberArray = new int[arraySize];
        this.stringArray = new String[arraySize];
    }

}
