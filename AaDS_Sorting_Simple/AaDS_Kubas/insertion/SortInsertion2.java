package insertion;

/**
 * Created by Rafał on 2017-03-22.
 */
public class SortInsertion2 extends SortInsertion {

    public SortInsertion2(int[] numberArray){
        super(numberArray);
    }

    public SortInsertion2(String[] stringArray){
        super(stringArray);
    }

    @Override
    public void performInsertionSortInt(int[] numberArray) {

        int smallest = numberArray[0];
        for(int i=0; i<numberArray.length; i++){
            if(numberArray[i] < smallest)
                smallest = numberArray[i];
        }

        int x, j;
        for (int i = 2; i < numberArray.length; i++)
        {
            x = numberArray[i];
            numberArray[0] = x;
            j = i - 1;
            while ((numberArray[j]>x))
            {
                numberArray[j + 1] = numberArray[j];
                j = j - 1;
            }
           numberArray[j + 1] = x;
        }
        numberArray[0] = smallest;


    }



    @Override
    public void performInsertionSortString(String[] stringArray) {
        String smallest = stringArray[0];
        for(int i=0; i<stringArray.length; i++){
            if( stringArray[i].compareTo(smallest) <0)
                smallest =  stringArray[i];
        }

        String x;
        int j;
        for (int i = 2; i <  stringArray.length; i++)
        {
            x =  stringArray[i];
             stringArray[0] = x;
            j = i - 1;
            while (( stringArray[j].compareTo(x)>0))
            {
                 stringArray[j + 1] =  stringArray[j];
                j = j - 1;
            }
             stringArray[j + 1] = x;
        }
         stringArray[0] = smallest;
    }

}

