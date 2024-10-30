import java.io.*;
import java.util.*;

public class Main
{
    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Pair {
        int x, y;

        public Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int count = 0;
        while (count < 2) {
            count = 0;
            time++;
            visited = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] == 0 && map[i][j] == 0) {
                        visited[i][j] = 1;
                        seaBfs(i, j);
                    }
                }
            }

            visited = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0 && visited[i][j] == 0) {
                        visited[i][j] = 1;
                        iceBfs(i, j);
                        count++;
                    }
                }
            }

            if (count == 0) {
                time = 0;
                break;
            }
        }

        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
        br.close();
	}

    static void seaBfs(int x, int y) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] != 0)
                    continue;

                if (map[nx][ny] != 0) {
                    map[nx][ny]--;
                    if (map[nx][ny] == 0)
                        visited[nx][ny] = 1;
                    continue;
                }
                
                visited[nx][ny] = 1;
                q.offer(new Pair(nx, ny));
            }
        }
    }

    static void iceBfs(int x, int y) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] != 0 || map[nx][ny] == 0)
                    continue;
                
                visited[nx][ny] = 1;
                q.offer(new Pair(nx, ny));
            }
        }
    }
}