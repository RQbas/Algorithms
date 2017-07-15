package shell;

import application.BasicData;
import application.BasicOperations;

import java.util.List;

public abstract class ShellSort{
    BasicOperations operations;
    BasicData data;


    public ShellSort(List list, String type) {
        operations = new BasicOperations(type);
        data = new BasicData(list);

        System.out.println("Performing:"+this.getClass());

        long startTime = System.nanoTime();
        performShellSort(data.getList());
        long endTime = System.nanoTime();

        double duration = (endTime - startTime)/1000000;
        System.out.println("Time: "+ duration+" mili seconds");

        operations.checkSortingCorrectness(data.getList());
    }

    public abstract void performShellSort(List list);



}
