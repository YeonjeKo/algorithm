import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][][] board = new int[5][5][5];
	static int[][][] board2 = new int[5][5][5];
	static int[] order = new int[5];
	static boolean[] isUsed = new boolean[5];
	static int[] dx = {0, 0, 0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0, 0, 0};
	static int[] dz = {0, 0, -1, 1, 0, 0};
	static boolean[][][] visited;
	static int min = Integer.MAX_VALUE;
			
	static class Pos {
		int x, y, z;
		
		Pos(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
			
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
        	for (int j = 0; j < 5; j++) {
        		st = new StringTokenizer(br.readLine());
        		for (int k = 0; k < 5; k++) {
        			board[i][j][k] = Integer.parseInt(st.nextToken());
        		}
        	}
        }
        
        rotate(0);
        
        if (min == Integer.MAX_VALUE) {
        	bw.write(String.valueOf(-1));
        } else {
        	bw.write(String.valueOf(min));
        }
        
        bw.flush();
        bw.close();
        br.close();
	}
	
	static void bfs() {
		Queue<Pos> q = new LinkedList<Pos>();
		if (board2[0][0][0] == 0)
			return;
		q.offer(new Pos(0, 0, 0));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			for (int i = 0; i < 6; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				int nz = pos.z + dz[i];
				
				if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || nz < 0 || nz >= 5 || visited[nx][ny][nz] == true)
					continue;
				if (board2[nx][ny][nz] == 0)
					continue;
				
				visited[nx][ny][nz] = true;
				board2[nx][ny][nz] = board2[pos.x][pos.y][pos.z] + 1;
				
				if (nx == 4 && ny == 4 && nz == 4) {
					if (min > board2[nx][ny][nz] - 1)
						min = board2[nx][ny][nz] - 1;
					return;
				}
				
				q.offer(new Pos(nx, ny, nz));
			}
		}
		
		return;
	}
	
	//순열
	static void stack(int k) {
		if (k == 5) {
			for (int x = 0; x < 5; x++) {
				for (int y = 0; y < 5; y++) {
					for (int z = 0; z < 5; z++) {
						board2[x][y][z] = board[order[x]][y][z];
					}
				}
			}
			
			visited = new boolean[5][5][5];
			bfs();
			
			return;
		}
		
		for (int i = 0; i < 5; i++) {
			if (!isUsed[i]) {
				order[k] = i;
				isUsed[i] = true;
				stack(k + 1);
				isUsed[i] = false;
			}
		}
	}

	//중복순열
	static void rotate(int k) {
		if (k == 5) {
			stack(0);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			//90도 회전
			int[][] tmp = new int[5][5];
			for (int x = 0; x < 5; x++) {
				for (int y = 0; y < 5; y++) {
					tmp[x][y] = board[k][5- y - 1][x];
				}
			}
			
			for (int x = 0; x < 5; x++) {
				for (int y = 0; y < 5; y++) {
					board[k][x][y] = tmp[x][y];
				}
			}
			
			rotate(k + 1);
		}
	}
	
}
