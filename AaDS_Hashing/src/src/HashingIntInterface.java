package src;

public interface HashingIntInterface extends HashingInterface {

    public void search(int soughtValue);
    public void insert(int additionalValue);
    public void displayArray(int[] array);
    public void performSearchHit();
    public void performSearchMiss();
}
