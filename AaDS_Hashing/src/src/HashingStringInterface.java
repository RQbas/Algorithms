package src;

public interface HashingStringInterface extends HashingInterface{
    public void search(String soughtString);
    public void insert(String additionalString);
    public void displayArray(String[] array);
    public void performSearchHit();
    public void performSearchMiss();
}
