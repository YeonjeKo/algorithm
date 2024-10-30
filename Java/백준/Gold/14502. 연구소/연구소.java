import java.io.*;
import java.util.*;

public class Main
{
    static int N, M;
    static int[][] map, tmp;
    static boolean[] isUsed;
    static int[] wall = new int[3];
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int max = Integer.MIN_VALUE;
    static List<Pos> virus = new ArrayList<Pos>();

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
//        tmp = new int[N][M];
        isUsed = new boolean[N * M];
//        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2)
                	virus.add(new Pos(i, j));
            }
        }
        
        func(0);
        
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
	}

    static void func(int k) {
        if (k == 3) {
        	copy();
            for (int i = 0; i < 3; i++) {
                tmp[wall[i] / M][wall[i] % M] = 1;
            }
            
            visited = new boolean[N][M];
            bfs();
            
            int count = 0;
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < M; j++) {
            		if (tmp[i][j] == 0)
            			count++;
            	}
            }
            
            if (max < count)
            	max = count;
            
            return;
        }

        int start = 0;
        if (k != 0)
            start = wall[k - 1] + 1;
        
        for (int i = start; i < N * M; i++) {
            if (!isUsed[i]) {
                if (map[i / M][i % M] == 0) {
                    wall[k] = i;
                    isUsed[i] = true;
                    func(k + 1);
                    isUsed[i] = false;
                }
            }
        }
    }

    static void bfs() {
        Queue<Pos> q = new LinkedList<Pos>();
        for (int i = 0; i < virus.size(); i++) {
        	q.offer(virus.get(i));
        }

        while (!q.isEmpty()) {
            Pos pos = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
                    continue;
                if (tmp[nx][ny] == 1)
                    continue;
                
                visited[nx][ny] = true;
                tmp[nx][ny] = 2;

                q.offer(new Pos(nx, ny));
            }
        }
    }
    
    static void copy() {
    	tmp = new int[N][M];
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < M; j++) {
    			tmp[i][j] = map[i][j];
    		}
    	}
    }
}