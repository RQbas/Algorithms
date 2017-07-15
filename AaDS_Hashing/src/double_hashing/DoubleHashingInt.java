package double_hashing;

import hashing.AbstractHashingInt;
import tools.Generator;

/**
 * Created by Rafał on 2017-05-24.
 */
public class DoubleHashingInt extends AbstractHashingInt {

    public DoubleHashingInt(Generator generator, float percentFill) {
        super(generator, percentFill);
    }

    @Override
    protected int basicHashFunction(int value) {
        return (value % arraySize);
    }


    protected int secondHashFunction(int value){
        return (value % (arraySize-1))+1;
    }

    @Override
    protected int hashFunction(int value, int elementIndex) {
        return ((basicHashFunction(value)+elementIndex*secondHashFunction(value)) % arraySize);
    }



}
