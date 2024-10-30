import java.io.*;
import java.util.*;

public class Main
{
    static int[][] map;
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

        map = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        ArrayList<Integer> sizeList= new ArrayList<Integer>();

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0 && map[i][j] == 1) {
                    visited[i][j] = 1;
                    sizeList.add(bfs(i, j));
                    count++;
                }
            }
        }

        Collections.sort(sizeList);

        bw.write(String.valueOf(count) + "\n");
        for (int i = 0; i < sizeList.size(); i++) {
            bw.write(String.valueOf(sizeList.get(i)) + "\n");
        }
        bw.flush();
        bw.close();
 	}

    static int bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(x, y));

        int size = 0;
        while (!q.isEmpty()) {
            Pair pos = q.poll();
            size++;

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] == 1 || map[nx][ny] == 0)
                    continue;
                
                visited[nx][ny] = 1;
                q.offer(new Pair(nx, ny));
            }
        }

        return size;
    }
}