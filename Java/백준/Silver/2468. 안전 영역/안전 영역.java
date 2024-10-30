import java.io.*;
import java.util.*;

public class Main
{
    static int[][] region;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;

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

        N = Integer.parseInt(br.readLine());
        region = new int[N][N];

        int max = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                region[i][j] = tmp;
                if (tmp > max)
                    max = tmp;
            }
        }

        int maxSafe = -1;
        for (int i = 0; i < max; i++) {
            visited = new int[N][N];
            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (visited[j][k] == 0 && region[j][k] > i) {
                        visited[j][k] = 1;
                        bfs(j, k, i);
                        count++;
                    }
                }
            }
            if (maxSafe < count)
                maxSafe = count;
        }

        bw.write(String.valueOf(maxSafe));
        bw.flush();
        bw.close();
	}

    public static void bfs(int x, int y, int n) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(x, y));

        while(!q.isEmpty()) {
            Pair pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] != 0 || region[nx][ny] <= n)
                    continue;
                
                visited[nx][ny] = 1;
                q.offer(new Pair(nx, ny));
            }
        }
    }
}
