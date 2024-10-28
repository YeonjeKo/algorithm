import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];
        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int[][] d = new int[n][3];
        d[0][0] = 0;
        d[0][1] = wine[0];
        d[0][2] = 0;
        for (int i = 1; i < n; i++) {
            d[i][0] = Math.max(d[i - 1][0], Math.max(d[i - 1][1], d[i - 1][2]));
            d[i][1] = d[i - 1][0] + wine[i];
            d[i][2] = d[i - 1][1] + wine[i];
        }

        bw.write(String.valueOf(Math.max(d[n - 1][0], Math.max(d[n - 1][1], d[n - 1][2]))));
        bw.flush();
        bw.close();
        br.close();
	}
}