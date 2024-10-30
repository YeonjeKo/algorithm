import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] d = new int[N][3];
        d[0][0] = house[0][0];
        d[0][1] = house[0][1];
        d[0][2] = house[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0)
                    d[i][j] = Math.min(d[i - 1][1], d[i - 1][2]) + house[i][j];
                else if (j == 1)
                    d[i][j] = Math.min(d[i - 1][0], d[i - 1][2]) + house[i][j];
                else
                    d[i][j] = Math.min(d[i - 1][0], d[i - 1][1]) + house[i][j];
            }
        }

        bw.write(String.valueOf(Math.min(d[N - 1][2], (Math.min(d[N - 1][0], d[N - 1][1])))));
        bw.flush();
        bw.close();
        br.close();
	}
}