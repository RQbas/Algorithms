package quick;

import application.BasicData;
import application.BasicOperations;

import java.util.List;

public abstract class QuickSort {
    BasicOperations operations;
    BasicData data;


    public QuickSort(List list, String type) {
        operations = new BasicOperations(type);
        data = new BasicData(list);
        System.out.println("Performing:"+this.getClass());
        long startTime = System.nanoTime();
        performQuickSort(data.getList());
        long endTime = System.nanoTime();

        double duration = (endTime - startTime)/1000000;
        System.out.println("Time: "+ duration+" mili seconds");
        operations.checkSortingCorrectness(data.getList());
    }

    public void swap(List list, int index1, int index2)
    {
        Object temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public abstract void performQuickSort(List list);
}
