package bubble;


public class SortBubble1 extends SortBubble{

    public SortBubble1(String[] stringArray) {
        super(stringArray);
    }
    public SortBubble1(int[] numberArray) {
        super(numberArray);
    }
    @Override
    public void performBubbleSortInt(int[] numberArray) {
       int temp;
	
		for(int i=0; i<numberArray.length; i++){
			for(int j=0; j<numberArray.length-1; j++){
				if(numberArray[j]>numberArray[j+1]){
					temp=numberArray[j+1];
					numberArray[j+1]=numberArray[j];
					numberArray[j]=temp;
				}
			}
		}
    }

    @Override
    public void performBubbleSortString(String[] stringArray) {
        String temp;
		
		for(int i=0; i<stringArray.length; i++){
			for(int j=0; j<stringArray.length-1; j++){
				if(stringArray[j].compareTo(stringArray[j+1]) > 0){
					temp = stringArray[j+1];
					stringArray[j+1]=stringArray[j];
					stringArray[j]=temp;
				}
			}
		}
    }
        
}
