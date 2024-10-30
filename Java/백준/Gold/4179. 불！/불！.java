import java.io.*;
import java.util.*;

public class Main
{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] maze;
    static int[][] fire, jihoon;
    static Queue<Pair> q = new LinkedList<Pair>();
    static int R, C;

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
        R = Integer.parseInt(str.split(" ")[0]);
        C = Integer.parseInt(str.split(" ")[1]);

        maze = new char[R][C];
        fire = new int[R][C];
        jihoon = new int[R][C];

        Pair jh = null;
        for (int i = 0; i < R; i++) {
            str = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = str.charAt(j);
                if (maze[i][j] == 'F') {
                    fire[i][j]++;
                    q.offer(new Pair(i, j));
                }
                if (str.charAt(j) == '#') {
                    fire[i][j] = -1;
                    jihoon[i][j] = -1;
                }
                if (maze[i][j] == 'J') {
                    jihoon[i][j]++;
                    jh = new Pair(i, j);
                }
            }
        }

        bfsFire();

        q.offer(jh);
        int time = bfsJihoon();
        if (time == -1) {
            bw.write("IMPOSSIBLE");
            bw.flush();
            return;
        }

        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
    }

    static void bfsFire() {
        while (!q.isEmpty()) {
            Pair point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || fire[nx][ny] > 0 || maze[nx][ny] == '#')
                    continue;

                fire[nx][ny] = fire[point.x][point.y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }
    }

    static int bfsJihoon() {
        while (!q.isEmpty()) {
            Pair point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                
                //탈출 성공
                if (nx < 0 || nx >= R || ny < 0 || ny >= C)
                    return jihoon[point.x][point.y];
                if (jihoon[nx][ny] > 0 || maze[nx][ny] == '#')
                    continue;
                //불에 막힐 때
                if (fire[nx][ny] != 0 && fire[nx][ny] <= jihoon[point.x][point.y] + 1) {
                    continue;
                }

                jihoon[nx][ny] = jihoon[point.x][point.y] + 1;
                q.offer(new Pair(nx, ny));
            }
        }
        return -1;
    }
}