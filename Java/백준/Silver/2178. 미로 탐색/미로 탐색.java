import java.io.*;
import java.util.*;

public class Main
{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] maze, visited;
    static int n, m;

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

        String str = br.readLine();
        n = Integer.parseInt(str.split(" ")[0]);
        m = Integer.parseInt(str.split(" ")[1]);

        maze = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1 && visited[i][j] == 0) {
                    visited[i][j]++;
                    bfs(i, j);
                }
            }
        }
        
        bw.write(String.valueOf(visited[n - 1][m - 1]));
        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] > 0 || maze[nx][ny] == 0)
                    continue;
                
                visited[nx][ny] = visited[point.x][point.y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }
    }
}