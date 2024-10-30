import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st;

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            cnt++;
            int[][] g = new int[N][3];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    g[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1) {
                        if (j == 0) {
                            g[i][j] += g[0][1];
                        } else if (j == 1)
                            g[i][j] += Math.min(g[i][j - 1], Math.min(g[i - 1][j], g[i - 1][j + 1] + g[0][1]));
                        else 
                            g[i][j] += Math.min(g[i][j - 1], Math.min(g[i - 1][j - 1], g[i - 1][j] + g[0][1]));
                        
                        continue;
                    }
                    
                    if (j == 0)
                        g[i][j] += Math.min(g[i - 1][j], g[i - 1][j + 1]);
                    else if (j == 1) {
                        int min = Integer.MAX_VALUE;
                        if (min >= g[i][j - 1])
                            min = g[i][j - 1];
                        if (min >= g[i - 1][j - 1])
                            min = g[i - 1][j - 1];
                        if (min >= g[i - 1][j])
                            min = g[i - 1][j];
                        if (min >= g[i - 1][j + 1])
                            min = g[i - 1][j + 1];

                        g[i][j] += min;
                        
                        if (i == N - 1)
                            break;
                    } else
                        g[i][j] += Math.min(g[i][j - 1], Math.min(g[i - 1][j - 1], g[i - 1][j]));
                }
            }

            sb.append(cnt + ". " + g[N - 1][1] + "\n");
        }

        System.out.print(sb);
	}
}