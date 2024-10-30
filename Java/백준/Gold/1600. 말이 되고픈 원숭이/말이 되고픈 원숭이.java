import java.io.*;
import java.util.*;

public class Main
{
    static int W, H;
    static int[][] board;
    static int[][][] visited;
    static int[] dx = {-1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2};

    static class Pair {
        int x, y, status;

        public Pair(int x, int y, int status) {
            this.x = x;
            this.y = y;
            this.status = status;
        }
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][W];
        visited = new int[K + 1][H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    visited[i][j][k] = -1;
                }
            }
        }
        
        visited[K][0][0]++;
        bfs(0, 0, K);

        int min = H * W;
        for (int i = 0; i <= K; i++) {
            if (visited[i][H - 1][W - 1] == -1)
                continue;
            if (min > visited[i][H - 1][W - 1])
                min = visited[i][H - 1][W - 1];
        }
        if (min == H * W)
            min = -1;

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y, int k) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(x, y, k));

        while (!q.isEmpty()) {
            Pair pos = q.poll();

            for (int i = 0; i < 12; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W || board[nx][ny] == 1)
                    continue;
                if (i > 3 && pos.status > 0 && visited[pos.status - 1][nx][ny] == -1) {
                    visited[pos.status - 1][nx][ny] = visited[pos.status][pos.x][pos.y] + 1;
                    q.offer(new Pair(nx, ny, pos.status - 1));
                }
                if (i <= 3 && visited[pos.status][nx][ny] == -1) {
                    visited[pos.status][nx][ny] = visited[pos.status][pos.x][pos.y] + 1;
                    q.offer(new Pair(nx, ny, pos.status));
                }
            }
        }

    }
}