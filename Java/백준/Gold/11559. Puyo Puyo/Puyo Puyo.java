import java.util.*;
import java.io.*;

public class Main
{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] field;
    static boolean[][] visited;
    static Queue<Pair> q;

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Pair> explode;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        field = new char[12][6];
        q = new LinkedList<Pair>();
        
        for (int i = 0; i < 12; i++) {
            String str = br.readLine();
            for (int j = 0; j < 6; j++) {
                field[i][j] = str.charAt(j);
            }
        }

        int count = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (field[i][j] != '.') {
                        visited[i][j] = true;
                        q.offer(new Pair(i, j));
                        explode = new ArrayList<Pair>();
                        //터뜨리기
                        if (bfs() >= 4) {
                            for (int k = 0; k < explode.size(); k++) {
                                field[explode.get(k).x][explode.get(k).y] = '.';
                            }
                            flag = true;
                        }
                    }
                }
            }
            fall();
            count++;
        }

        bw.write(String.valueOf(count - 1));
        bw.flush();
        bw.close();
        br.close();
	}

    static int bfs() {
        int count = 0;
        while (!q.isEmpty()) {
            Pair point = q.poll();
            explode.add(point);
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || field[nx][ny] != field[point.x][point.y] || visited[nx][ny])
                    continue;
                
                visited[nx][ny] = true;
                q.offer(new Pair(nx, ny));
            }
        }

        return count;
    }

    static void fall() {
        for (int j = 0; j < 6; j++) {
            int tmp = 11;
            while (tmp > 0) {
                if (field[tmp][j] == '.') {
                    int tmp2 = tmp;
                    while (tmp2 > 1 && field[tmp2 - 1][j] == '.')
                        tmp2--;
                    field[tmp][j] = field[tmp2 - 1][j];
                    field[tmp2 - 1][j] = '.';
                }
                tmp--;
            }
        }
    }
}