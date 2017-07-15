package linear_probing;

import hashing.AbstractHashingString;
import tools.Generator;

/**
 * Created by Rafał on 2017-05-20.
 */
public class LinearProbingString extends AbstractHashingString{

    public LinearProbingString(Generator generator, float percentFill) {
        super(generator, percentFill);
    }

    protected int basicHashFunction(String value){
        return (value.hashCode() % arraySize);
    }

    protected int hashFunction(String value, int elementIndex){
        return ((basicHashFunction(value)+elementIndex) % arraySize);
    }
}
