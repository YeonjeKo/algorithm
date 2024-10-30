import java.util.*;
import java.io.*;

public class Main
{
    static int[] board;
    static int N, cnt;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N];

        func(0);

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
	}

    static void func(int k) {
        if (!check(k - 1))
            return;

        if (k == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[k] = i;
            func(k + 1);
        }
    }

    static boolean check(int k) {
        for (int i = 0; i < k; i++) {
            if (board[i] == board[k] || Math.abs(board[k] - board[i]) == k - i)
                return false;
        }

        return true;
    }
}