import java.util.*;
import java.io.*;

public class Main
{   
    static StringBuilder sb = new StringBuilder();
    static int[][] video;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        video = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                video[i][j] = str.charAt(j) - '0';
            }
        }

        video(N, 0, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}

    static void video(int n, int x, int y) {
        if (n == 1) {
            if (video[x][y] == 0)
                sb.append(0);
            if (video[x][y] == 1)
                sb.append(1);
            return;
        }

        boolean isSame = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (video[i + x][j + y] != video[x][y]) {
                    isSame = false;
                    break;
                }
            }
        }

        if (isSame) {
            if (video[x][y] == 0)
                sb.append(0);
            if (video[x][y] == 1)
                sb.append(1);
            return;
        }
        
        sb.append("(");
        for (int i = 0; i < n; i += n / 2) {
            for (int j = 0; j < n; j += n / 2) {
                video(n / 2, x + i, y + j);
            }
        }
        sb.append(")");
    }
}