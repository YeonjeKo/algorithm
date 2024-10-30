import java.io.*;
import java.util.*;

public class Main
{
    static int N;
    static int[][] map, visited, newMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Pair> q2;

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new int[N][N];
        newMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int land = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0 && map[i][j] == 1) {
                    visited[i][j] = 1;
                    newMap[i][j] = ++land;
                    landBfs(i, j, land);
                }
            }
        }

        q2 = new LinkedList<Pair>();
        int min = N * N;
        for (int k = 0; k < land; k++) {
            visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (newMap[i][j] == 0) {
                        if (i - 1 >= 0 && newMap[i - 1][j] == k + 1 || i + 1 < N && newMap[i + 1][j] == k + 1 || j - 1 >= 0 && newMap[i][j - 1] == k + 1 || j + 1 < N && newMap[i][j + 1] == k + 1)
                        {   
                            visited[i][j] = 1;                     
                            q2.offer(new Pair(i, j));
                        }
                    } 
                }
            }
            int tmp = bridgeBfs(k + 1);
            if (min > tmp)
                min = tmp;
        }

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
	}

    public static void landBfs(int x, int y, int land) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] != 0 || map[nx][ny] == 0)
                    continue;
                
                visited[nx][ny] = 1;
                newMap[nx][ny] = land;
                q.offer(new Pair(nx, ny));
            }
        }
    }

    public static int bridgeBfs(int land) {
        int min = N * N;
        while (!q2.isEmpty()) {
            Pair pos = q2.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] > 0)
                    continue;
                if (map[nx][ny] == 1 && newMap[nx][ny] != land) {
                    if (min > visited[pos.x][pos.y])
                        min = visited[pos.x][pos.y];
                    continue;
                }

                visited[nx][ny] = visited[pos.x][pos.y] + 1;
                q2.offer(new Pair(nx, ny));
            }
        }

        return min;
    }
}