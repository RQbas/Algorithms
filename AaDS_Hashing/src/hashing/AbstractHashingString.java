package hashing;

import src.HashingIntInterface;
import src.HashingStringInterface;
import tools.Generator;
import tools.TestingClassInt;

/**
 * Created by Rafał on 2017-05-25.
 */
public abstract class AbstractHashingString implements HashingStringInterface {

    public String[] array = new String[arraySize];
    public String[] notExistingString = new String[testSize];
    TestingClassInt testingClass = new TestingClassInt();
    Generator generator;

    public AbstractHashingString(Generator generator, float percentFill){
        this.generator = generator;
        fillArray( percentFill);
        performSearchHit();
        performSearchMiss();

    }
    protected abstract int basicHashFunction(String value);
    protected abstract int hashFunction(String value, int elementIndex);



    private void fillArray(float percentFill) {
        System.out.println("Hashing "+getClass().toString());
        for(int i=0; i<arraySize; i++)
            array[i]="";
        for(int i=0; i<(int) arraySize*percentFill ; i++)
            insert(generator.generatedArrayString[i]);

    }

    @Override
    public void search(String soughtString) {
        int index = 0;
        for(int i = 0; i< arraySize; i++){
            index = Math.abs(hashFunction(soughtString, i));
            testingClass.increaseOperationCount();
            if(array[index].equals(soughtString)){
                break;
            }
            if(array[index].equals(""))
                break;
        }
    }

    @Override
    public void insert(String additionalString) {
        int index=0;
        for(int i=0; i<arraySize; i++){
            index = Math.abs(hashFunction(additionalString, i));
            if(array[index].equals("")){
                array[index] = additionalString;
                break;
            }
        }
    }

    @Override
    public void displayArray(String[] array) {
            for(String s: array)
                System.out.print(s+" ");
            System.out.println("");
    }

    @Override
    public void performSearchHit() {
        for(int i=0; i<testSize; i++)
            search(generator.generatedArrayString[generator.getRandomIndex()]);
        System.out.println("Hit: "+(float) testingClass.getOperationCount()/testSize);
        testingClass.cleanOperationCount();
    }

    @Override
    public void performSearchMiss() {
        this.notExistingString = this.generator.notExistingString;
        for(int i=0; i<testSize; i++)
            search(notExistingString[i]);
        System.out.println("Miss: "+(float) testingClass.getOperationCount()/testSize);
        testingClass.cleanOperationCount();
    }
}
