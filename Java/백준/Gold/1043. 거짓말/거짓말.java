import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void putEdge(ArrayList<ArrayList<Integer>> g, int x, int y) {
		g.get(x).add(y);
		g.get(y).add(x);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int truthN = Integer.parseInt(st.nextToken());
		int[] truth = new int[truthN];
		for (int i = 0; i < truthN; i++) {
			truth[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			g.add(new ArrayList<>());
		}
		int[][] party = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < tmp; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
			}
			
			if (tmp == 1)
				continue;
			
			int x = 0;
			int y = 1;
			while (x < tmp - 1) {
				int n1 = party[i][x];
				int n2 = party[i][y];
				putEdge(g, n1, n2);
				y++;
				if (y == tmp || n2 == 0) {
					x++;
					y = x + 1;
				}
			}
		}
		
		boolean[] visited = new boolean[N + 1];
		for (int i = 0; i < truthN; i++) {
			bfs(truth[i], g, N, visited);
		}
		
		int cnt = 0;
		for (int i = 0; i < M; i++ ) {
			int j = 0;
			boolean flag = true;
			while (j < N && party[i][j] != 0) {
				if (visited[party[i][j]] == true) {
					flag = false;
					break;
				}
				j++;
			}
			if (flag)
				cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static void bfs(int start, ArrayList<ArrayList<Integer>> g, int n, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < g.get(cur).size(); i++) {
				int next = g.get(cur).get(i);
				if (visited[next] == false) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
	}

}
