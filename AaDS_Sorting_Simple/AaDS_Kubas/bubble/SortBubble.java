package bubble;
import application.BasicOperations;

public abstract class SortBubble extends BasicOperations {
    public abstract void performBubbleSortInt(int[] numberArray);
    public abstract void performBubbleSortString(String[] stringArray);
    
    public SortBubble(int[] numberArray) {
    	this.numberArray = numberArray.clone();
		System.out.println("Performing:"+this.getClass());

		long startTime = System.nanoTime();
		performBubbleSortInt(this.numberArray);
		long endTime = System.nanoTime();

		double duration = (endTime - startTime)/1000000;
		System.out.println("Time: "+ duration+" mili seconds");

		checkSortingCorrectionInt(this.numberArray);
	}

public SortBubble(String[] stringArray) {
		this.stringArray = stringArray.clone();

		System.out.println("Performing:"+this.getClass());

		long startTime = System.nanoTime();
		performBubbleSortString(this.stringArray);
		long endTime = System.nanoTime();

	double duration = (endTime - startTime)/1000000;
	System.out.println("Time: "+ duration+" mili seconds");
		checkSortingCorrectionString(this.stringArray);
	}
}
