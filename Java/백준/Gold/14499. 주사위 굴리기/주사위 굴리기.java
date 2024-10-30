import java.util.*;
import java.io.*;

public class Main
{
    static int[] dice;
    static int[][] map;
    static int N, M, x, y;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sb = new StringBuilder();
        dice = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            move(dir);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}

    static void move(int dir) {
        switch (dir) {
            case 1:
                if (x < 0 || y + 1 < 0 || x >= N || y + 1 >= M)
                    return;
                y++;
                int tmp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[3];
                dice[3] = dice[5];
                dice[5] = tmp;
                break;
            case 2:
                if (x < 0 || y - 1 < 0 || x >= N || y - 1 >= M)
                    return;
                y--;
                tmp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[3];
                dice[3] = dice[4];
                dice[4] = tmp;
                break;
            case 3:
                if (x - 1 < 0 || y < 0 || x - 1 >= N || y >= M)
                    return;
                x--;
                tmp = dice[0];
                for (int i = 0; i < 3; i++) {
                    dice[i] = dice[i + 1];
                }
                dice[3] = tmp;
                break;
            case 4:
                if (x + 1 < 0 || y < 0 || x + 1 >= N || y >= M)
                    return;
                x++;
                tmp = dice[3];
                for (int i = 2; i >= 0; i--) {
                    dice[i + 1] = dice[i];
                }
                dice[0] = tmp;
                break;

        }

        if (map[x][y] == 0) {
            map[x][y] = dice[3];
        } else {
            dice[3] = map[x][y];
            map[x][y] = 0;
        }

        sb.append(dice[1] + "\n");
    }
}