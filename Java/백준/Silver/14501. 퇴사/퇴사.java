import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N][2];
        int[] d = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                schedule[i][j] = Integer.parseInt(st.nextToken());
                if (j == 1 && i + schedule[i][0] - 1 < N)
                    d[i] = schedule[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (i + schedule[i][0] - 1 < N) {
                    if (i > j + schedule[j][0] - 1)
                        d[i] = Math.max(d[i], d[j] + schedule[i][1]);
                }
            }

            if (max < d[i])
                max = d[i];
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
	}
}