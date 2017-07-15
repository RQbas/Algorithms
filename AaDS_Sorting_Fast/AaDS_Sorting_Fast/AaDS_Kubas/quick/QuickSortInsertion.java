package quick;

import java.util.List;

public class QuickSortInsertion extends QuickSort{
    public QuickSortInsertion(List list, String type){
        super(list, type);
    }

    @Override
    public void performQuickSort(List list) {
        quickSort(list, 0, list.size()-1);
    }

    public void quickSort(List list, int start, int end) {
        if(start < end)
        {
            if((end-start)<9)
                InsertionSort(list, start, end + 1);
            else
            {
                int part = partition(list, start, end);
                quickSort(list, start, part-1);
                quickSort(list, part + 1, end);
            }
        }
    }

    public void InsertionSort(List list, int start, int end)
    {
        for (int x = start + 1; x < end; x++)
        {
            Object temp = list.get(x);
            int j = x-1;
            while (j >= 0 && !operations.compareValue(temp, list.get(j)))
            {
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, temp);
        }
    }
    private int partition(List list, int st, int end)
    {
        int rand = (int) (st + (Math.random()*((end-st)+1)));
        Object temp = list.get(rand);
        swap(list, end, rand);
        temp = list.get(end);
        int i = st-1;
        for(int j=st;j<=end-1;j++)
        {
            if(!operations.compareValue(list.get(j), temp)){
                i = i+1;
                swap(list, i,j);
            }
        }
        swap(list, i+1,end);
        return i+1;
    }
}
