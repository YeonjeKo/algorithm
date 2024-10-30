//방문확인을 큐에서 뺄 때 하면 안되고 넣을 때 해야 함 안그러면 시간초과 or 메모리초과!!!!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int N;
	static int H;
	
	static class Point {
		int x, y, z;
		
		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner s = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
//		M = s.nextInt();
//		N = s.nextInt();
//		H = s.nextInt();
		
		int[][][] box = new int[H][N][M];
		//boolean[][][] visited = new boolean[H][N][M];
		
		Queue<Point> que = new LinkedList<Point>();
		
		boolean check = false;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					//box[i][j][k] = s.nextInt();
					if (box[i][j][k] == 1) {
						que.add(new Point(i, j, k));
						//visited[i][j][k] = true;
					}
					if (box[i][j][k] == 0) {
						check = true;
					}
				}
			}
		}
		
		if (!check) {
			System.out.println("0");
			return;
		}
		
		int count = 0;
			
		while(!que.isEmpty()) {

			int size = que.size();
			for (int i = 0; i < size; i++) {
				Point point = que.poll();

				//			if (visited[point.x][point.y][point.z] == true) {
				//				count++;
				//				visited = new boolean[H][N][M];
				//			}

				if (point.y != 0 && box[point.x][point.y - 1][point.z] == 0) {
					//visited[point.x][point.y - 1][point.z] = true;
					//visited[point.x][point.y - 1][point.z]++;
					box[point.x][point.y - 1][point.z] = 1;
					que.add(new Point(point.x, point.y - 1, point.z));
				}
				if (point.z != 0 && box[point.x][point.y][point.z - 1] == 0) {
					//visited[point.x][point.y][point.z - 1]++;
					box[point.x][point.y][point.z - 1] = 1;
					que.add(new Point(point.x, point.y, point.z - 1));
					//				box[point.x][point.y][point.z - 1] = 1;
					//visited[point.x][point.y][point.z - 1] = true;
					//				que.add(new Point(point.x, point.y, point.z - 1));
				}
				if (point.z != M - 1 && box[point.x][point.y][point.z + 1] == 0) {
					//visited[point.x][point.y][point.z + 1]++;
					box[point.x][point.y][point.z + 1] = 1;
					que.add(new Point(point.x, point.y, point.z + 1));
					//				box[point.x][point.y][point.z + 1] = 1;
					//visited[point.x][point.y][point.z + 1] = true;
					//				que.add(new Point(point.x, point.y, point.z + 1));
				}
				if (point.y != N - 1 && box[point.x][point.y + 1][point.z] == 0) {
					//visited[point.x][point.y + 1][point.z]++;
					box[point.x][point.y + 1][point.z] = 1;
					que.add(new Point(point.x, point.y + 1, point.z));
					//				box[point.x][point.y + 1][point.z] = 1;
					//visited[point.x][point.y + 1][point.z] = true;
					//				que.add(new Point(point.x, point.y + 1, point.z));
				}
				if (point.x != 0 && box[point.x - 1][point.y][point.z] == 0) {
					//visited[point.x - 1][point.y][point.z]++;
					box[point.x - 1][point.y][point.z] = 1;
					que.add(new Point(point.x - 1, point.y, point.z));
					//				box[point.x - 1][point.y][point.z] = 1;
					//visited[point.x - 1][point.y][point.z] = true;
					//				que.add(new Point(point.x - 1, point.y, point.z));
				}
				if (point.x != H - 1 && box[point.x + 1][point.y][point.z] == 0) {
					//visited[point.x + 1][point.y][point.z]++;
					box[point.x + 1][point.y][point.z] = 1;
					que.add(new Point(point.x + 1, point.y, point.z));
					//				box[point.x + 1][point.y][point.z] = 1;
					//visited[point.x + 1][point.y][point.z] = true;
					//				que.add(new Point(point.x + 1, point.y, point.z));
				}
			}
			count++;
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (box[i][j][k] == 0) {
						System.out.println("-1");
						return;
					}
				}
			}
		}
		
		System.out.println(count - 1);
	}

	
}
