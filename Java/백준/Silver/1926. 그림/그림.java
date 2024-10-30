import java.io.*;
import java.util.*;

public class Main
{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] paper, visited;
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

        paper = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1 && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    int size = bfs(i, j);
                    if (max < size)
                        max = size;
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count) + "\n" + String.valueOf(max));
        bw.flush();
        bw.close();
    }

    static int bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(x, y));

        int size = 0;
        while (!q.isEmpty()) {
            Pair point = q.poll();
            size++;
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] == 1 || paper[nx][ny] == 0)
                    continue;
                
                visited[nx][ny] = 1;
                q.offer(new Pair(nx, ny));
            }
        }

        return size;
    }
}