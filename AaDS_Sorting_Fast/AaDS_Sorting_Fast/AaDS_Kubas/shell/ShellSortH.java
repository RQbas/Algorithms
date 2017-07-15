package shell;

import java.util.List;

/**
 * Created by Rafał on 2017-04-08.
 */
public class ShellSortH extends ShellSort {

    public ShellSortH(List list, String type){
        super(list, type);
    }
    @Override
    public void performShellSort(List list){
        int h = 1;
        while((h*3+1) < list.size())
            h = 3*h+1;
        while(h > 0){
            for(int i = h-1; i < list.size(); i++){
                Object temp = list.get(i);
                int j=i;
                for(j = i; (j>=h) && (operations.compareValue(list.get(j-h), temp)); j-=h)
                    list.set(j, list.get(j-h));
                list.set(j, temp);
            }
            h /= 3;
        }
    }
}
