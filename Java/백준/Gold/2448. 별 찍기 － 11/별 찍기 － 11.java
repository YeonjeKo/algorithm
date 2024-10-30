import java.util.*;
import java.io.*;

public class Main
{
    static char[][] star;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        star = new char[N][2 * N - 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                star[i][j] = ' ';
            }
        }

        func(N, 0, N - 1);

        for (int i = 0; i < N; i++) {
            String str = "";
            for (int j = 0; j < 2 * N - 1; j++) {
                bw.write(Character.toString(star[i][j]));
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
	}

    static void func(int n, int x, int y) {
        if (n == 3) {
            star[x][y] = '*';
            star[x + 1][y - 1] = '*';
            star[x + 1][y + 1] = '*';
            y = y - 2;
            for (int i = 0; i < 5; i++) {
                star[x + 2][y + i] = '*';
            }

            return;
        }

        func(n / 2, x, y);
        func(n / 2, x + n / 2, y - n / 2);
        func(n / 2, x + n / 2, y + n / 2);
    }
}