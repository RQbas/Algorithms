package shell;

import java.util.List;

/**
 * Created by Rafał on 2017-04-08.
 */
public class ShellSortN2 extends ShellSort {

    public ShellSortN2(List list, String type){
        super(list, type);
    }
//gap sequence: n/2, n/4, ..., 1 Shell's concept of gap
    @Override
    public void performShellSort(List list) {
        for (int gap = list.size() / 2; gap > 0; gap /= 2) {
            // do the insertion sort
            for (int i = gap; i < list.size(); i++) {
                Object temp = list.get(i);
                int j;
                for (j = i; j >= gap &&  operations.compareValue(list.get(j-gap), temp); j -= gap) {
                    list.set(j, list.get(j-gap));
                }
                list.set(j, temp);
            }
        }
    }


}
