import java.util.*;
import java.io.*;

public class Main
{
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] board;
    static int l;

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];
            
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int knightX = Integer.parseInt(tokenizer.nextToken());
            int knightY = Integer.parseInt(tokenizer.nextToken());
            board[knightX][knightY]++;
            bfs(knightX, knightY);
            
            tokenizer = new StringTokenizer(br.readLine());
            int destX = Integer.parseInt(tokenizer.nextToken());
            int destY = Integer.parseInt(tokenizer.nextToken());

            bw.write(String.valueOf(board[destX][destY] - 1) + "\n");
        }

        bw.flush();
        bw.close();
	}

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(x, y));

        while(!q.isEmpty()) {
            Pair pos = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || nx >= l || ny < 0 || ny >= l || board[nx][ny] > 0)
                    continue;
                
                board[nx][ny] = board[pos.x][pos.y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }
    }
}