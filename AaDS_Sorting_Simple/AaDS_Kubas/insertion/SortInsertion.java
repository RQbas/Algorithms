package insertion;

import application.BasicOperations;

public abstract class SortInsertion extends BasicOperations {
    public abstract void performInsertionSortInt(int[] numberArray);
    public abstract void performInsertionSortString(String[] stringArray);

    public SortInsertion(int[] numberArray) {
        this.numberArray = numberArray.clone();


        System.out.println("Performing:"+this.getClass());

        long startTime = System.nanoTime();
        performInsertionSortInt(this.numberArray);
        long endTime = System.nanoTime();

        double duration = (endTime - startTime)/1000000;
        System.out.println("Time: "+ duration+" mili seconds");


        checkSortingCorrectionInt(this.numberArray);
    }

    public SortInsertion(String[] stringArray) {
        this.stringArray = stringArray.clone();

        System.out.println("Performing:"+this.getClass());

        long startTime = System.nanoTime();
        performInsertionSortString(this.stringArray);
        long endTime = System.nanoTime();

        double duration = (endTime - startTime)/1000000;
        System.out.println("Time: "+ duration+" mili seconds");
        checkSortingCorrectionString(this.stringArray);
    }
}
