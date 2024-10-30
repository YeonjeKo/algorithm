import java.util.*;
import java.io.*;

public class Main
{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] picture, weaknessPicture;
    static int[][] visited;
    static int N;

    static class Pair {
        int x, y;
        char c;

        public Pair(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        picture = new char[N][N];
        weaknessPicture = new char[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                picture[i][j] = str.charAt(j);
                if (str.charAt(j) == 'G')
                    weaknessPicture[i][j] = 'R';
                else 
                    weaknessPicture[i][j] = str.charAt(j);
            }
        }

        //정상
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    visited[i][j] = 1;
                    bfs(i, j, false);
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count) + " ");

        //적록색약
        visited = new int[N][N];
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    visited[i][j] = 1;
                    bfs(i, j, true);
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
	}

    static void bfs(int x, int y, boolean isWeakness) {
        Queue<Pair> q = new LinkedList<Pair>();
        if (isWeakness) {
            q.offer(new Pair(x, y, weaknessPicture[x][y]));
        } else {
            q.offer(new Pair(x, y, picture[x][y]));
        }

        while (!q.isEmpty()) {
            Pair point = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] == 1)
                    continue;
                if (isWeakness && point.c != weaknessPicture[nx][ny] || !isWeakness && point.c != picture[nx][ny])
                    continue;

                visited[nx][ny] = 1;
                if (isWeakness) {
                    q.offer(new Pair(nx, ny, weaknessPicture[nx][ny]));
                } else {
                    q.offer(new Pair(nx, ny, picture[nx][ny]));
                }
            }
        }
    }
}