package quick;

import java.util.List;
import java.util.Random;

public class QuickSortRandom extends QuickSort{
    final private static Random random = new Random();
    public QuickSortRandom(List list, String type){
        super(list, type);
    }

    @Override
    public void performQuickSort(List list) {
        quickSort(list, 0, list.size()-1);
    }

    public void quickSort(List list, int start, int end) {
        if(start>end)
            return;

        int cut = partition(list, start,end);

        quickSort(list, start,cut-1);
        quickSort(list, cut+1,end);
    }

    private int partition(List list, int st, int end)
    {
        int rand = (int) (st + (Math.random()*((end-st)+1)));
        swap(list, end, rand);
        Object temp = list.get(end);
        int i = st-1;
        for(int j=st;j<=end-1;j++)
        {
            if(!operations.compareValue(list.get(j), temp)) {
                i = i+1;
                swap(list, i,j);
            }
        }
        swap(list, i+1,end);
        return i+1;
    }
}
