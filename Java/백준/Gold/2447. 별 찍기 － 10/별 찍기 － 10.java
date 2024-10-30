import java.util.*;
import java.io.*;

public class Main
{   
    static char[][] star;
    static boolean isBlank = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        star = new char[N][N];

        func(N, 0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(Character.toString(star[i][j]));
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
	}

    static void func(int n, int x, int y) {
        if (isBlank) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    star[x + i][y + j] = ' ';
                }
            }
            isBlank = false;
            return;
        }

        if (n == 1) {
            if (isBlank) {
                star[x][y] = ' ';
                isBlank = false;
            }
            else
                star[x][y] = '*';
            return;
        } 

        for (int i = 0; i < n; i += n / 3) {
            for (int j = 0; j < n; j += n / 3) {
                if (i == n / 3 && j == n / 3)
                    isBlank = true;
                func(n / 3, x + i, y + j);
            }
        }
    }
}