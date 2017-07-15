package double_hashing;

import hashing.AbstractHashingString;
import tools.Generator;

/**
 * Created by Rafał on 2017-05-25.
 */
public class DoubleHashingString extends AbstractHashingString {


    public DoubleHashingString(Generator generator, float percentFill) {
        super(generator, percentFill);
    }

    @Override
    protected int basicHashFunction(String value) {
        return (value.hashCode() % arraySize);
    }


    protected int secondHashFunction(String value){
        return (value.hashCode() % (arraySize-1))+1;
    }

    @Override
    protected int hashFunction(String value, int elementIndex) {
        return ((basicHashFunction(value)+elementIndex*secondHashFunction(value)) % arraySize);
    }

}
