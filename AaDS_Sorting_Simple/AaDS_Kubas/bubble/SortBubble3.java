package bubble;

/**
 * Created by Rafał on 2017-03-22.
 */
public class SortBubble3 extends SortBubble {
    public SortBubble3(String[] stringArray) {
        super(stringArray);
    }

    @Override
    public void performBubbleSortInt(int[] numberArray) {
        {
            int bottom = 0;
            int buffor = 0;
            int top = numberArray.length - 1;
            boolean change = true;
            while(change == true) {
                change = false;
                for(int i = bottom; i < top; i++) {
                    if(numberArray[i] > numberArray[i + 1]) {
                         buffor=numberArray[i];
                        numberArray[i] = numberArray[i+1];
                        numberArray[i+1] = buffor;
                        change = true;
                    }
                }
                top = top - 1;
                for(int i = top; i > bottom; i--) {
                    if(numberArray[i] < numberArray[i - 1]) {
                        buffor=numberArray[i] ;
                        numberArray[i] = numberArray[i-1];
                        numberArray[i-1] = buffor;
                        change = true;
                    }
                }
                bottom = bottom + 1;
            }
        }
    }

    @Override
    public void performBubbleSortString(String[] stringArray) {
        int bottom = 0;
       String buffor;
        int top = stringArray.length - 1;
        boolean change = true;
        while(change == true) {
            change = false;
            for(int i = bottom; i < top; i++) {
                if(stringArray[i].compareTo(stringArray[i + 1])>0) {
                    buffor=stringArray[i];
                    stringArray[i] =stringArray[i+1];
                    stringArray[i+1] = buffor;
                    change = true;
                }
            }
            top = top - 1;
            for(int i = top; i > bottom; i--) {
                if(stringArray[i].compareTo(stringArray[i - 1]) < 0) {
                    buffor=stringArray[i] ;
                    stringArray[i] = stringArray[i-1];
                    stringArray[i-1] = buffor;
                    change = true;
                }
            }
            bottom = bottom + 1;
        }
    }


    public SortBubble3(int[] numberArray) {
        super(numberArray);
    }



}
