import java.util.*;
import java.io.*;

public class Main
{
    static char[][] pos = new char[5][5];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] arr = new int[7];
    static boolean[] isUsed = new boolean[25];
    static boolean[][] visited = new boolean[5][5];
    static int[][] pos2;
    static int count = 0;

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 5; i++) {
            pos[i] = br.readLine().toCharArray();
        }

        func(0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
	}

    static void func(int k) {
        if (k == 7) {
            pos2 = new int[5][5];
            int countS = 0;
            for (int i = 0; i < 7; i++) {
                if (pos[arr[i] / 5][arr[i] % 5] == 'S') {
                    countS++;
                }
                pos2[arr[i] / 5][arr[i] % 5] = 1;
            }

            if (countS >= 4) {
                visited = new boolean[5][5];
                visited[arr[0] / 5][arr[0] % 5] = true;
                bfs(arr[0] / 5, arr[0] % 5);
            }
            
            return;
        }

        int start = 0;
        if (k != 0)
            start = arr[k - 1] + 1;
        
        for (int i = start; i < 25; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false;
            }
        }
    }

    static void bfs(int x, int y) {
        Queue <Pair> q = new LinkedList<Pair>();
        q.offer(new Pair(x, y));

        int size = 0;
        while (!q.isEmpty()) {
            Pair point = q.poll();
            size++;
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny] == true || pos2[nx][ny] == 0)
                    continue;

                visited[nx][ny] = true;
                q.offer(new Pair(nx, ny));
            }
        }

        if (size == 7) {
            count++;
        }
    }
}