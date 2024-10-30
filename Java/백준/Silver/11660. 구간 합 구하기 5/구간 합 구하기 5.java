import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] d = new int[N][N];
        d[0][0] = map[0][0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0)
                    continue;
                else if (i == 0)
                    d[i][j] = d[i][j - 1] + map[i][j];
                else if (j == 0)
                    d[i][j] = d[i - 1][j] + map[i][j];
                else
                	d[i][j] = d[i][j - 1] + d[i - 1][j] - d[i - 1][j - 1] + map[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int rslt = d[x2][y2];
            
            if (x1 == 0 && y1 == 0) {
            	sb.append(rslt).append("\n");
            	continue;
            }
            else if (x1 == 0)
            	rslt = rslt - d[x2][y1 - 1];
            else if (y1 == 0)
            	rslt = rslt - d[x1 - 1][y2];
            else
            	rslt = rslt - d[x2][y1 - 1] - d[x1 - 1][y2] + d[x1 - 1][y1 - 1];

            sb.append(rslt).append("\n");
        }

        System.out.print(sb);
	}

}
