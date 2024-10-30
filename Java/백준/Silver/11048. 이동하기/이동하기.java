import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] d = new int[N][M];
        d[0][0] = maze[0][0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0) {
                    if (j == 0)
                        continue;
                    d[i][j] = maze[i][j] + d[i][j - 1];
                    continue;
                }
                
                if (j == 0) {
                    if (i == 0)
                        continue;
                    d[i][j] = maze[i][j] + d[i - 1][j];
                    continue;
                }

                d[i][j] = Math.max(d[i - 1][j - 1], Math.max(d[i - 1][j], d[i][j - 1])) + maze[i][j];
            }
        }

        System.out.println(d[N - 1][M - 1]);
	}
}