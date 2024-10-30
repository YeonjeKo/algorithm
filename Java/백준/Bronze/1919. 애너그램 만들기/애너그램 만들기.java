import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//import java.lang.Math;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for (int i = 0; i < c1.length; i++) {
            a1[c1[i] - 97]++;
        }
        for (int i = 0; i < c2.length; i++) {
            a2[c2[i] - 97]++;
        }

        int count = 0;
        for (int i = 0; i < a1.length; i++) {
            count += Math.abs(a1[i] - a2[i]);
        }

        System.out.println(count);
	}
}