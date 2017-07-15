package hashing;

import src.HashingIntInterface;
import tools.Generator;
import tools.TestingClassInt;

/**
 * Created by Rafał on 2017-05-25.
 */
public abstract class AbstractHashingInt implements HashingIntInterface {

    public int[] array = new int[arraySize];
    TestingClassInt testingClass = new TestingClassInt();
    Generator generator;

    public AbstractHashingInt(Generator generator, float percentFill){
        this.generator = generator;
        fillArray( percentFill);
        performSearchHit();
        performSearchMiss();
    }


    protected abstract int basicHashFunction(int value);
    protected abstract int hashFunction(int value, int elementIndex);

    public void fillArray(float percentFill){
        System.out.println("Hashing "+getClass().toString());
        for(int i=0; i<(int) arraySize*percentFill ; i++)
                insert(generator.generatedArrayInt[i]);
    }


    @Override
    public void performSearchHit(){
        for(int i=0; i<testSize; i++)
            search(generator.generatedArrayInt[generator.getRandomIndex()]);
        System.out.println("Hit: "+(float) testingClass.getOperationCount()/testSize);
        testingClass.cleanOperationCount();
    }
    @Override
    public void performSearchMiss(){
        for(int i=0; i<testSize; i++)
            search(i);
        System.out.println("Miss: "+(float) testingClass.getOperationCount()/testSize);
        testingClass.cleanOperationCount();
    }

    @Override
    public void search(int soughtValue) {
        int index = 0;
        for(int i = 0; i< arraySize; i++){
            index = Math.abs(hashFunction(soughtValue, i));
            testingClass.increaseOperationCount();
            if(array[index] == soughtValue){
                break;
            }
            if(array[index]==0)
                break;
        }
    }

    @Override
    public void insert(int additionalValue) {
        int index=0;
        for(int i=0; i<arraySize; i++){
            index = Math.abs(hashFunction(additionalValue, i));
            if(array[index] == 0){
                array[index] = additionalValue;
                break;
            }
        }
    }

    @Override
    public void displayArray(int[] array) {
        for(int i: array)
            System.out.print(i+" ");
        System.out.println("");
    }
}
