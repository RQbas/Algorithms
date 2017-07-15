package src;

import double_hashing.DoubleHashingInt;
import double_hashing.DoubleHashingString;
import hashing.AbstractHashingInt;
import hashing.AbstractHashingString;
import linear_probing.LinearProbingInt;
import linear_probing.LinearProbingString;
import tools.Generator;

public class Execution {

    public static void main(String[] args){
        float percentFill = 0.5f;
        Generator generator = new Generator(percentFill);
        new LinearProbingInt(generator, percentFill);
        new DoubleHashingInt(generator, percentFill);
        new DoubleHashingString(generator, percentFill);
        new LinearProbingString(generator, percentFill);
    }
}
