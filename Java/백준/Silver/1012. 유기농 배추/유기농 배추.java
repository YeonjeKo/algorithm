import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static Queue<Point> que = new LinkedList<Point>();
	static int M, N;
	static int[][] field;
	static int[][] visited;
	
	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			field = new int[M][N];
			visited = new int[M][N];
			
			for (int j = 0; j < K; j++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
	
				field[X][Y] = 1;
			}
			
			int count = 0;
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (field[j][k] == 1 && visited[j][k] == 0) {
						visited[j][k] = 1;
						bfs(j, k);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
	}

	public static void bfs(int x, int y) {
		que.add(new Point(x, y));
		
		while(!que.isEmpty()) {
			Point point = que.poll();

			if (point.y != N - 1 && field[point.x][point.y + 1] == 1 && visited[point.x][point.y + 1] == 0) {
				visited[point.x][point.y + 1] = 1;
				que.add(new Point(point.x, point.y + 1));
			}
			if (point.x != M - 1 && field[point.x + 1][point.y] == 1 && visited[point.x + 1][point.y] == 0) {
				visited[point.x + 1][point.y] = 1;
				que.add(new Point(point.x + 1, point.y));
			}
			if (point.x != 0 && field[point.x - 1][point.y] == 1 && visited[point.x - 1][point.y] == 0) {
				visited[point.x - 1][point.y] = 1;
				que.add(new Point(point.x - 1, point.y));
			}
			if (point.y != 0 && field[point.x][point.y - 1] == 1 && visited[point.x][point.y - 1] == 0) {
				visited[point.x][point.y - 1] = 1;
				que.add(new Point(point.x, point.y - 1));
			}
		}
		
		return;
	}
}
