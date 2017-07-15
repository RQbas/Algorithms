package insertion;

/**
 * Created by Rafał on 2017-03-22.
 */
public class SortInsertion1 extends SortInsertion {

    public SortInsertion1(int[] numberArray){
        super(numberArray);
    }

   public SortInsertion1(String[] stringArray){
        super(stringArray);
    }
    @Override
    public void performInsertionSortInt(int[] numberArray) {
        int value;
        int j;
        for(int i=1; i<numberArray.length; i++){
            j=i;
            value=numberArray[i];
            while(j>0 && numberArray[j-1]>value){
                numberArray[j]=numberArray[j-1];
                j--;
            }
            numberArray[j]=value;
        }
    }

    @Override
    public void performInsertionSortString(String[] stringArray) {

            String value;
            int j;
            for(int i=1; i<stringArray.length; i++){
                j=i;
                value=stringArray[i];
                while(j>0 && stringArray[j-1].compareTo(value)>0){
                    stringArray[j]=stringArray[j-1];
                    j--;
                }
                stringArray[j]=value;
            }
    }
}
