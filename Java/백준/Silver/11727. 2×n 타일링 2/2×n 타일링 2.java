import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n];
        d[0] = 1;
        if (n > 1)
            d[1] = 3;
        for (int i = 2; i < n; i++) {
            d[i] = (2 * d[i - 2] + d[i - 1]) % 10007;                                                                                                                                                                          
        }

        bw.write(String.valueOf(d[n - 1]));
        bw.flush();
        bw.close();
        br.close();
	}
}