package bubble;

/**
 * Created by Rafał on 2017-03-22.
 */
public class SortBubble2 extends SortBubble {
    public SortBubble2(int[] numberArray) {
    super(numberArray);
}
    public SortBubble2(String[] stringArray) {
        super(stringArray);
    }

    @Override
    public void performBubbleSortInt(int[] numberArray) {
        int temp,swaps;
        for( int i = 0 ; i < numberArray.length - 2 ; i++ ) {
            swaps=0;
            for ( int j = 0 ; j < numberArray.length - 1 ; j++ )
            {
                if ( numberArray[j] > numberArray[j + 1] )
                {
                    temp = numberArray[j];
                    numberArray[j] = numberArray[j + 1];
                    numberArray[j + 1] = temp;
                    swaps++;
                }
            }
            if( swaps == 0 )
            {
                break;
            }
        }

    }

    @Override
    public void performBubbleSortString(String[] stringArray) {
        int swaps;
        String temp;
        for( int i = 0 ; i < stringArray.length - 2 ; i++ ) {
            swaps=0;
            for ( int j = 0 ; j < stringArray.length - 1 ; j++ )
            {
                if ( stringArray[j].compareTo(stringArray[j + 1]) >0  )
                {
                    temp = stringArray[j];
                    stringArray[j] = stringArray[j + 1];
                    stringArray[j + 1] = temp;
                    swaps++;
                }
            }
            if( swaps == 0 )
            {
                break;
            }
        }
    }


}
