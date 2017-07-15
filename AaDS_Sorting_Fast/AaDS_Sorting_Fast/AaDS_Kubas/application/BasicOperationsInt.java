package application;

import java.util.List;

/**
 * Created by Rafał on 2017-03-31.
 */
public interface BasicOperationsInt {
    public abstract void showList(List list);
    public abstract void fillWithRandomData(List list, int dataSize);
    public void checkSortingCorrectness(List list);

}
