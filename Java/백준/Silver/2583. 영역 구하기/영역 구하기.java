import java.io.*;
import java.util.*;

public class Main
{
    static int[][] paper;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M, N;

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

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        paper = new int[M][N];
        visited = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    paper[j][k] = 1;
                }
            }
        }

        ArrayList<Integer> sizeList = new ArrayList<Integer>();
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0 && paper[i][j] == 0) {
                    visited[i][j] = 1;
                    sizeList.add(bfs(i, j));
                    count++;
                }
            }
        }

        Collections.sort(sizeList);

        bw.write(String.valueOf(count) + "\n");
        for (int i = 0; i < sizeList.size(); i++) {
            bw.write(String.valueOf(sizeList.get(i)) + " ");
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

                if (nx < 0|| nx >= M|| ny < 0 || ny >= N || visited[nx][ny] == 1 || paper[nx][ny] == 1)
                    continue;
                
                visited[nx][ny] = 1;
                q.offer(new Pair(nx, ny));
            }
        }

        return size;
    }
}