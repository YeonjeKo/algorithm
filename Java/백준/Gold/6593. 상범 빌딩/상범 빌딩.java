import java.io.*;
import java.util.*;

public class Main
{
    static char[][][] building;
    static int[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int L, R, C;

    static class Point {
        int x, y, z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        while (L != 0 || R != 0 || C != 0) {
            building = new char[L][R][C];
            visited = new int[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        visited[i][j][k] = -1;
                    }
                }
            }

            Point escape = null;
            Point start = null;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = str.charAt(k);
                        if (str.charAt(k) == 'E') {
                            escape = new Point(i, j, k);
                        }
                        if (str.charAt(k) == 'S') {
                            visited[i][j][k]++;
                            start = new Point(i, j, k);
                        }
                    }
                }
                br.readLine();
            }

            bfs(start.x, start.y, start.z);

            if (visited[escape.x][escape.y][escape.z] == -1) {
                bw.write("Trapped!\n");
            } else {
                bw.write("Escaped in " + String.valueOf(visited[escape.x][escape.y][escape.z]) + " minute(s).\n");
            }

            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());      
        }   

        bw.flush();
        bw.close();
	}

    public static void bfs(int x, int y, int z) {
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(x, y, z));

        while(!q.isEmpty()) {
            Point pos = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                int nz = pos.z + dz[i];

                if (nx < 0 || nx >= L || ny < 0 || ny >= R || nz < 0 || nz >= C || visited[nx][ny][nz] >= 0 || building[nx][ny][nz] == '#')
                    continue;
                
                visited[nx][ny][nz] = visited[pos.x][pos.y][pos.z] + 1;
                q.offer(new Point(nx, ny, nz));
            }
        }
    }
}
