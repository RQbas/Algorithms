package quick;

import java.util.List;

/**
 * Created by Rafał on 2017-04-08.
 */
public class QuickSortMedian extends QuickSort {
    public QuickSortMedian(List list, String type) {
        super(list, type);
    }

    @Override
    public void performQuickSort(List list) {
        quickSort(list, 0, list.size() - 1);
    }



        public void quickSort(List list, int start, int end) {
        if(start>end)
            return;

        int partition = partition(list, start, end);

        quickSort(list, start, partition-1);
        quickSort(list, partition+1, end);
    }

    public int getMedian(List list, int left,int right){
        int center = (left+right)/2;

        if(operations.compareValue(list.get(left), list.get(right)))
            swap(list, left, right);
        if(operations.compareValue(list.get(left), list.get(center)))
            swap(list, left, center);
        if(operations.compareValue(list.get(center), list.get(right)))
            swap(list, center, right);

        return center;
    }

    private int partition(List list, int st, int end)
    {
        int temp_Index = getMedian(list, st, end);
        swap(list, end, temp_Index);
        Object temp = list.get(end);
        int i = st-1;
        for(int j=st;j<=end-1;j++)
        {
            if(!operations.compareValue(list.get(j), temp))
            {
                i = i+1;
                swap(list, i,j);
            }
        }
        swap(list, i+1,end);
        return i+1;
    }

}
