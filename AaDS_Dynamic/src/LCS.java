import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Timer;

/**
 * Created by Rafał on 2017-06-05.
 */
public abstract class LCS {
    int[][] distances;
    String lcs;
    StringBuffer operations = new StringBuffer();
    int distance;
    int delete;
    int insert;
    int substitution;
    long startTime;
    long endTime;


    public LCS(String a, String b) {
        performSearchingLCS(a, b);
        performSearchingEditDistance(a, b);
    }

    public abstract String getLCS(String a, String b);

    public abstract void getEditDistance(String a, String b);


    protected void displayLCS() {
        System.out.println("LCS time: " + (endTime - startTime) / 1000 + "us");
        System.out.println("Substring: " + lcs);
        System.out.println("Length: " + lcs.length());
    }

    protected void displayDistance() {
        System.out.println("Distance time: " + (endTime - startTime) / 1000 + "us");
        System.out.println("Distance: " + distance);
        System.out.println("Operations: " + operations.toString());
        System.out.println();
    }

    protected void performSearchingLCS(String a, String b) {
        System.out.println(this.getClass());
        System.out.println("Strings: " + a + ", " + b);
        startTime = System.nanoTime();
        lcs = getLCS(a, b);
        endTime = System.nanoTime();
        displayLCS();
    }

    protected void performSearchingEditDistance(String a, String b) {
        startTime = System.nanoTime();
        getEditDistance(a, b);
        endTime = System.nanoTime();
        displayDistance();
    }

}
