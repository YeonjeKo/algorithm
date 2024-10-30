import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] trgl = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                trgl[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Integer[][] d = new Integer[n][n];
        d[0][0] = trgl[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    d[i][j] = d[i - 1][j] + trgl[i][j];
                else if (j == i)
                    d[i][j] = d[i - 1][j - 1] + trgl[i][j];
                else
                    d[i][j] = Math.max(d[i - 1][j - 1] + trgl[i][j], d[i - 1][j] + trgl[i][j]);
            }
        }

        List<Integer> fin = Arrays.asList(d[n - 1]);
        bw.write(String.valueOf(Collections.max(fin)));
        bw.flush();
        bw.close();
        br.close();
	}
}