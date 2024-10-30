import java.util.*;
import java.io.*;

public class Main
{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] building;
    static int[][] fire, sanggeun;
    static int w, h;
    static Queue<Pair> fireQ, sgQ;

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

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            w = Integer.parseInt(tokenizer.nextToken());
            h = Integer.parseInt(tokenizer.nextToken());
            building = new char[h][w];
            fire = new int[h][w];
            sanggeun = new int[h][w];
            fireQ = new LinkedList<Pair>();
            sgQ = new LinkedList<Pair>();
            
            for (int j = 0; j < h; j++) {
                String str = br.readLine();
                for (int k = 0; k < w; k++) {
                    building[j][k] = str.charAt(k);

                    if (building[j][k] == '*') {
                        fire[j][k]++;
                        fireQ.offer(new Pair(j, k));
                    }
                    if (building[j][k] == '#') {
                        fire[j][k] = -1;
                        sanggeun[j][k] = -1;
                    }
                    if (building[j][k] == '@') {
                        sanggeun[j][k]++;
                        sgQ.offer(new Pair(j, k));
                    }
                }
            }
            
            fireBfs();
            int time = sgBfs();
            if (time == -1) {
                bw.write("IMPOSSIBLE\n");
            } else {
                bw.write(String.valueOf(time) + "\n");
            }
        }

        bw.flush();
        bw.close();
	}

    static void fireBfs() {
        while(!fireQ.isEmpty()) {
            Pair pos = fireQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w || fire[nx][ny] > 0 || building[nx][ny] == '#')
                    continue;
                
                fire[nx][ny] = fire[pos.x][pos.y] + 1;
                fireQ.offer(new Pair(nx, ny));
            }
        }
    }

    static int sgBfs() {
        while(!sgQ.isEmpty()) {
            Pair pos = sgQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                //탈출 성공
                if (nx < 0 || nx >= h || ny < 0 || ny >= w)
                    return sanggeun[pos.x][pos.y];
                if (sanggeun[nx][ny] > 0 || building[nx][ny] == '#')
                    continue;
                //불에 막힐 때
                if (fire[nx][ny] != 0 && fire[nx][ny] <= sanggeun[pos.x][pos.y] + 1)
                    continue;
                
                sanggeun[nx][ny] = sanggeun[pos.x][pos.y] + 1;
                sgQ.offer(new Pair(nx, ny));
            }
        }
        return -1;
    }
}