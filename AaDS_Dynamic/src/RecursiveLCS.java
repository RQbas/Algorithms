/**
 * Created by Rafał on 2017-06-06.
 */
public class RecursiveLCS extends LCS {

    public RecursiveLCS(String a, String b) {
        super(a, b);
    }

    @Override
    public String getLCS(String a, String b) {
        int alength = a.length() - 1;
        int blength = b.length() - 1;

        if (alength < 0 || blength < 0)
            return "";

        if (a.substring(alength).equals(b.substring(blength))) {
            return getLCS(a.substring(0, alength), b.substring(0, blength))
                    + a.substring(alength);
        } else {
            String first = getLCS(a, b.substring(0, blength));
            String second = getLCS(a.substring(0, alength), b);
            if (first.length() > second.length()) {
                return first;
            } else {
                return second;
            }
        }
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
