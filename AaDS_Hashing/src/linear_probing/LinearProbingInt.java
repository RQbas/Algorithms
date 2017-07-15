package linear_probing;

import hashing.AbstractHashingInt;
import tools.Generator;

public class LinearProbingInt extends AbstractHashingInt {

    public LinearProbingInt(Generator generator, float percentFill) {
        super(generator, percentFill);
    }


    public int basicHashFunction(int value){
        return (value%arraySize);
    }

    public int hashFunction(int value, int elementIndex){
        return ((basicHashFunction(value)+elementIndex) % arraySize);
    }


}
