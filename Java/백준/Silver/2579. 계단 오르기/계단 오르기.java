import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n];
        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        int[][] d = new int[n][2];
        d[0][0] = stairs[0];
        if (n > 1) {
            d[1][0] = stairs[1];
            d[1][1] = stairs[0] + stairs[1];
        }
        
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0)
                    d[i][j] = Math.max(d[i - 2][0], d[i - 2][1]) + stairs[i];
                else
                    d[i][j] = d[i - 1][0] + stairs[i];
            }
        }

        bw.write(String.valueOf(Math.max(d[n - 1][0], d[n - 1][1])));
        bw.flush();
        bw.close();
        br.close();
	}
}