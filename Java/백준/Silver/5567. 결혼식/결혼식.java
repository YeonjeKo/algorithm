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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			g.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			 st = new StringTokenizer(br.readLine());
			 int n1 = Integer.parseInt(st.nextToken());
			 int n2 = Integer.parseInt(st.nextToken());
			 
			 putEdge(g, n1, n2);
		}
		
		System.out.println(bfs(1, g, n));
	}

	public static int bfs(int start, ArrayList<ArrayList<Integer>> g, int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		int[] visited = new int[n + 1];
		Arrays.fill(visited, -1);
		visited[start]++;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < g.get(cur).size(); i++) {
				int next = g.get(cur).get(i);
				if (visited[next] == -1) {
					visited[next] = visited[cur] + 1;
					q.offer(next);
				}
			}
		}
		
		int cnt = 0;
		for (int i = 2; i <= n; i++) {
			if (visited[i] <= 2 && visited[i] != -1)
				cnt++;
		}
		
		return cnt;
	}
	
}
