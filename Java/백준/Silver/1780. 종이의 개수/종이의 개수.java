import java.util.*;
import java.io.*;

public class Main
{   
    static int[][] paper;
    static int count_1;
    static int count0;
    static int count1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paper(N, 0, 0);

        bw.write(String.valueOf(count_1 + "\n" + count0 + "\n" + count1));
        bw.flush();
        bw.close();
	}

    static void paper(int n, int x, int y) {
        if (n == 1) {
            if (paper[x][y] == -1)
                count_1++;
            if (paper[x][y] == 0)
                count0++;
            if (paper[x][y] == 1)
                count1++;
            return;
        }

        boolean isSame = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (paper[i + x][j + y] != paper[x][y]) {
                    isSame = false;
                    break;
                }
            }
        }

        if (isSame) {
            if (paper[x][y] == -1)
                count_1++;
            if (paper[x][y] == 0)
                count0++;
            if (paper[x][y] == 1)
                count1++;
            return;
        }

        for (int i = 0; i < n; i += n / 3) {
            for (int j = 0; j < n; j += n / 3) {
                paper(n / 3, x + i, y + j);
            }
        }
    }
}