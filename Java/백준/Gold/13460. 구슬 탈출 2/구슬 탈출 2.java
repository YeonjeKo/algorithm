import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//1. 백트래킹
public class Main { 
	
	static int N, M;
	static char[][] board;
	static char[][] tmp;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[] dir = new int[10];
	static int count = 0;
	static int min = Integer.MAX_VALUE;
	static Pos r_blue, r_red;
	
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
        board = new char[N][M];
        tmp = new char[N][M];
        
        for (int i = 0; i < N; i++) {
        	String str = br.readLine();
        	for (int j = 0; j < M; j++) {
        		board[i][j] = str.charAt(j);
        		if (board[i][j] == 'B')
        			r_blue = new Pos(i, j);
        		if (board[i][j] == 'R')
        			r_red = new Pos(i, j);
        	}
        }
        
        func(0);
        
        if (min > 10)
        	min = -1;
        
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
	}
	
	static void func(int k) {
		if (k == 10) {
			tilt();
			if (count != -1 && min > count)
				min = count;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			dir[k] = i;
			func(k + 1);
		}
	}
	
	static void tilt() {	
		Pos blue = new Pos(r_blue.x, r_blue.y);
		Pos red = new Pos(r_red.x, r_red.y);
		
		count = 0;
		for (int i = 0; i < 10; i++) {
			if (count != 0)
				break;
			
			boolean flag = false;
			
			//Blue
			while (true) {
				int nx = blue.x + dx[dir[i]];
				int ny = blue.y + dy[dir[i]];
				
				if (board[nx][ny] == '#')
					break;
				if (board[nx][ny] == 'O') {
					count = -1;
					return;
				}
				if (red.x == nx && red.y == ny) {
					flag = true;
					break;
				}
				
				blue.x = nx;
				blue.y = ny;
			}
			
			//Red
			while (true) {
				int nx = red.x + dx[dir[i]];
				int ny = red.y + dy[dir[i]];
				
				if (board[nx][ny] == '#' || (blue.x == nx && blue.y == ny))
					break;
				
				red.x = nx;
				red.y = ny;
				
				if (board[nx][ny] == 'O') {
					count = i + 1;
					red.x += dx[dir[i]];
					red.y += dy[dir[i]];
					break;
				}
			}
			
			if (flag) {
				blue.x = red.x - dx[dir[i]];
				blue.y = red.y - dy[dir[i]];
				if (board[blue.x][blue.y] == 'O') {
					count = -1;
					return;
				}
					
			}
				
			if (i == 9 && count == 0)
				count = -1;
		}
	}
	
}
