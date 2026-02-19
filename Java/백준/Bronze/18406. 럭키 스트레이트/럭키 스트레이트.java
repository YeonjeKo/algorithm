import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();

        String str1 = N.substring(0, N.length() / 2);
        String str2 = N.substring(N.length() / 2);

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < c1.length; i++) {
            sum1 += c1[i] - '0';
            sum2 += c2[i] - '0';
        }

        if (sum1 == sum2)
            System.out.println("LUCKY");
        else
            System.out.println("READY");

    }
}