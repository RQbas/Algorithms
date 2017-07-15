package application;

import quick.*;
import shell.ShellSort;
import shell.ShellSortH;
import shell.ShellSortN2;

import java.util.ArrayList;

public class AlgorithmCore{

    private BasicOperations operations;
    private BasicData data;
    
    public AlgorithmCore(int size, String type){
        operations = new BasicOperations(type);
        data = new BasicData(size);
        operations.fillWithRandomData(data.getList(), data.getDataSize());

        new QuickSortFirst(data.getList(), operations.getType());
       new QuickSortRandom(data.getList(), operations.getType());
        new QuickSortMedian(data.getList(), operations.getType());
      new QuickSortInsertion(data.getList(), operations.getType());
        new ShellSortH(data.getList(), operations.getType());
        new ShellSortN2(data.getList(), operations.getType());





    }





}
