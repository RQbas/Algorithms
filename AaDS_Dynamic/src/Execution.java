import java.security.cert.LDAPCertStoreParameters;

/**
 * Created by Rafał on 2017-06-05.
 */
public class Execution {

    public static void main(String[] args) {
        String A = "EXECUTION";
        String B = "INTENTION";

        new IterativeLCS(A, B);
        new RecursiveLCS(A, B);
    }
}
