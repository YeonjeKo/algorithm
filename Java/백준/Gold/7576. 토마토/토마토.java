import java.io.*;
import java.util.*;

public class Main
{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] box, visited;
    static Queue<Pair> q = new LinkedList<Pair>();
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
        m = Integer.parseInt(str.split(" ")[0]);
        n = Integer.parseInt(str.split(" ")[1]);

        box = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(stk.nextToken()); 
                if (box[i][j] == 1) {
                    visited[i][j]++;
                    q.offer(new Pair (i, j));
                }
                if (box[i][j] == -1)
                    visited[i][j] = -1;
            }
        }

        int day = bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    bw.write(String.valueOf(-1));
                    bw.flush();
                    return;
                }
            }
        }

        bw.write(String.valueOf(day));
        bw.flush();
        bw.close();
    }

    static int bfs() {
        Pair point = null;
        while (!q.isEmpty()) {
            point = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] > 0 || box[nx][ny] == -1)
                    continue;
                
                visited[nx][ny] = visited[point.x][point.y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }

        if (point != null)
            return visited[point.x][point.y] - 1;
        return 0;
    }
}