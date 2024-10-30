import java.util.*;
import java.io.*;

public class Main {

	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	static class Pos {
		int x, y;
		
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[][] grid = new int[101][101];
        
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	int g = Integer.parseInt(st.nextToken());

        	grid[y][x] = 1;

        	Stack<Integer> dir = new Stack<>();
        	dir.push(d);

        	Pos last = new Pos(y + dx[d], x + dy[d]);
        	grid[last.x][last.y] = 1;
        	//grid[x][y] = 1;

        	for (int k = 1; k <= g; k++) {
        		Stack<Integer> nDir = new Stack<>();
        		nDir.addAll(dir);

        		while(!dir.isEmpty()) {
        			int tDir = dir.pop();
        			if (tDir == 3) {
        				tDir = 0;
        			} else {
        				tDir++;
        			}
        			
        			Pos tmp = new Pos(last.x + dx[tDir], last.y + dy[tDir]);
        			grid[tmp.x][tmp.y] = 1;
        			last = tmp;
        			nDir.push(tDir);
        		}
        		
        		dir = nDir;
        	}
        }
        
        int count = 0;
        for (int i = 0; i < 100; i++) {
        	for (int j = 0; j < 100; j++) {
        		if (grid[i][j] != 1)
        			continue;
        		if (grid[i][j + 1] == 1 && grid[i + 1][j] == 1 && grid[i + 1][j + 1] == 1)
        			count++;
        	}
        }
        
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

}
