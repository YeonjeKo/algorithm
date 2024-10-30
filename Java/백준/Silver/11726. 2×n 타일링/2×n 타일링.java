import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n][2];
        d[0][0] = 1;
        d[0][1] = 0;
        for (int i = 1; i < n; i++) {
            d[i][0] = d[i - 1][0] + d[i - 1][1] % 10007;
            d[i][1] = d[i - 1][0] % 10007;
        }

        bw.write(String.valueOf((d[n - 1][0] + d[n - 1][1]) % 10007));
        bw.flush();
        bw.close();
        br.close();
	}
}