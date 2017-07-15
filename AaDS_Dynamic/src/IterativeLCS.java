import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Rafał on 2017-06-06.
 */
public class IterativeLCS extends LCS {
    int[][] lengths;

    IterativeLCS(String a, String b) {
        super(a, b);
    }

    @Override
    public String getLCS(String a, String b) {
        lengths = new int[a.length() + 1][b.length() + 1];

        fillSubsequenceMatrix(a, b);

        return retrieveSubsequence(a, b).reverse().toString();
    }

    void fillSubsequenceMatrix(String a, String b) {
        for (int i = 0; i < a.length(); i++)
            for (int j = 0; j < b.length(); j++)
                if (a.charAt(i) == b.charAt(j))
                    lengths[i + 1][j + 1] = lengths[i][j] + 1;
                else
                    lengths[i + 1][j + 1] =
                            Math.max(lengths[i + 1][j], lengths[i][j + 1]);
    }

    StringBuffer retrieveSubsequence(String a, String b) {
        StringBuffer sb = new StringBuffer();
        for (int x = a.length(), y = b.length();
             x != 0 && y != 0; ) {
            if (lengths[x][y] == lengths[x - 1][y])
                x--;
            else if (lengths[x][y] == lengths[x][y - 1])
                y--;
            else {
                assert a.charAt(x - 1) == b.charAt(y - 1);
                sb.append(a.charAt(x - 1));
                x--;
                y--;
            }
        }
        return sb;
    }

    @Override
    public void getEditDistance(String a, String b) {
        distances = new int[a.length() + 1][b.length() + 1];

        fillInitialEditMatrix(a, b);
        fillEditMatrix(a, b);

        retrieveOperationString(a, b);
    }


    public void fillInitialEditMatrix(String a, String b) {
        for (int i = 0; i <= a.length(); i++)
            distances[i][0] = i;

        for (int i = 0; i <= b.length(); i++)
            distances[0][i] = i;
    }


    public void fillEditMatrix(String a, String b) {
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {

                delete = distances[i - 1][j] + 1;
                insert = distances[i][j - 1] + 1;
                substitution = distances[i - 1][j - 1] + ((a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1));

                distances[i][j] = getMin(delete, insert, substitution);
            }
        }
        this.distance = distances[a.length()][b.length()];
    }

    public void retrieveOperationString(String a, String b) {
        int i = a.length();
        int j = b.length();
        int min;

        while (i != 0 && j != 0) {

            delete = distances[i][j - 1];
            insert = distances[i - 1][j];
            substitution = distances[i - 1][j - 1];
            min = getMin(delete, insert, substitution);

            if (min == substitution) {
                if (distances[i][j] == distances[i - 1][j - 1]) {
                    operations.insert(0, " " + a.charAt(i - 1) + " ");
                } else {
                    operations.insert(0, "sub(" + a.charAt(i - 1) + "," + b.charAt(j - 1) + ") ");
                }
                i -= 1;
                j -= 1;

            } else if (min == delete) {
                operations.insert(0, "del(" + a.charAt(i - 1) + ") ");
                j -= 1;
            } else if (min == insert) {
                operations.insert(0, "ins(" + a.charAt(i - 1) + ") ");
                i -= 1;
            }
        }
    }


    public int getMin(int val1, int val2, int val3) {
        return (val1 < val2 ? val1 : val2) > val3 ? val3 : (val1 < val2 ? val1 : val2);
    }
}
