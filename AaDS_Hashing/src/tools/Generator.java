package tools;

import java.security.SecureRandom;

import static src.HashingInterface.arraySize;
import static src.HashingInterface.testSize;

public class Generator {
    public int[] generatedArrayInt = new int[arraySize];
    public String[] generatedArrayString = new String[arraySize];
    public String[] notExistingString = new String[testSize];
    float percentFill;

    public Generator(float percentFill){
        this.percentFill = percentFill;
        generateArrayInt();
        generateArrayString(generatedArrayString);
        generateNotExistingString(notExistingString);
    }
    private void generateArrayInt(){
        for(int i=0; i<arraySize; i++) {
            generatedArrayInt[i] = generateRandomInt();
        }
    }
    public int generateRandomInt() {
        return (int) ((Math.random()*Integer.MAX_VALUE)+testSize); //<testSize, MAX_INT>
    }
    void generateArrayString(String[] stringArray){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        for(int j=0; j<stringArray.length; j++ ){
            int sizeOfString = (int)(Math.random()*10+3);
            StringBuilder sb = new StringBuilder( sizeOfString );
            for( int i = 0; i < sizeOfString; i++ )
                sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
            stringArray[j] = sb.toString();
        }

    }
    void generateNotExistingString(String[] stringArray) {
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        for (int j = 0; j < stringArray.length; j++) {
            int sizeOfString = (int) (2);
            StringBuilder sb = new StringBuilder(sizeOfString);
            for (int i = 0; i < sizeOfString; i++)
                sb.append(AB.charAt(rnd.nextInt(AB.length())));
            stringArray[j] = sb.toString();

        }
    }

    public int getRandomIndex() {
    return (int) (Math.random()*arraySize*percentFill);
    }
}
