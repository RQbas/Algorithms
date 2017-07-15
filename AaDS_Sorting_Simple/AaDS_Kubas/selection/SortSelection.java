package selection;


import application.BasicOperations;

public class SortSelection extends BasicOperations {

    public SortSelection(int[] numberArray) {
        this.numberArray = numberArray.clone();

        System.out.println("Performing:"+this.getClass());

        long startTime = System.nanoTime();
        performSelectionSortInt(this.numberArray);
        long endTime = System.nanoTime();

        double duration = (endTime - startTime)/1000000;
        System.out.println("Time: "+ duration+" mili seconds");

        checkSortingCorrectionInt(this.numberArray);
    }

    public SortSelection(String[] stringArray) {
        this.stringArray = stringArray.clone();

        System.out.println("Performing:"+this.getClass());

        long startTime = System.nanoTime();
        performSelectionSortString(this.stringArray);
        long endTime = System.nanoTime();

        double duration = (endTime - startTime)/1000000;
        System.out.println("Time: "+ duration+" mili seconds");

        checkSortingCorrectionString(this.stringArray);
    }

    public void performSelectionSortInt(int[] numberArray) {
        int minIndex;
        int tmp;
        for (int i = 0; i < numberArray.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < numberArray.length; j++)
                if (numberArray[j] < numberArray[minIndex])
                    minIndex = j;
            if (minIndex != i) {
                tmp = numberArray[i];
                numberArray[i] = numberArray[minIndex];
                numberArray[minIndex] = tmp;
            }
        }

    }

    public void performSelectionSortString(String[] stringArray) {
        int minIndex;
        String tmp;
        for (int i = 0; i < stringArray.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < stringArray.length; j++)
                if (stringArray[j].compareTo(stringArray[minIndex])<0)
                    minIndex = j;
            if (minIndex != i) {
                tmp = stringArray[i];
                stringArray[i] = stringArray[minIndex];
                stringArray[minIndex] = tmp;
            }
        }
    }

}