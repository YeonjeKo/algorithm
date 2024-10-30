import java.io.*;
import java.util.*;

public class Main
{
    static int N, M;
    static int[][] map;
    static int[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y, isBroken;

        public Point (int x, int y, int isBroken) {
            this.x = x;
            this.y = y;
            this.isBroken = isBroken;
        }
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new int[N][M][2];

        initVisited();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        visited[0][0][0] = 1;
        visited[0][0][1] = 1;
        bfs(0, 0);

        if (visited[N - 1][M - 1][0] == -1) {
            bw.write(String.valueOf(visited[N - 1][M - 1][1]));
        } else if (visited[N - 1][M - 1][1] == -1) {
            bw.write(String.valueOf(visited[N - 1][M - 1][0]));
        } else {
            bw.write(String.valueOf(Math.min(visited[N - 1][M - 1][0], visited[N - 1][M - 1][1])));
        }

        bw.flush();
        bw.close();
        br.close();
	}

    static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(x, y, 0));

        while (!q.isEmpty()) {
            Point pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                
                if (map[nx][ny] == 1) {
                    if (pos.isBroken == 0 && visited[nx][ny][1] == -1) {
                        visited[nx][ny][1] = visited[pos.x][pos.y][pos.isBroken] + 1;
                        q.offer(new Point(nx, ny, 1));
                    }
                } else {
                    if (visited[nx][ny][pos.isBroken] == -1) {
                        visited[nx][ny][pos.isBroken] = visited[pos.x][pos.y][pos.isBroken] + 1;
                        q.offer(new Point(nx, ny, pos.isBroken));
                    }
                }
            }
        }
    }

    static void initVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j][0] = -1;
                visited[i][j][1] = -1;
            }
        }
    }
}