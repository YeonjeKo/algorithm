import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static Stack<Integer> st = new Stack<Integer>();
	static int[] student;
	static int[] visited;
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			count = 0;
			int n = Integer.parseInt(br.readLine());
			
			student = new int[n];
			visited = new int[n];
			
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			for (int j = 0; j < n; j++) {
				student[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < n; j++) {
				dfs(j);
			}
			
			System.out.println(count);
		}
	}

	public static void dfs(int a) {
        
		if (visited[a] != 1) {
			visited[a] = 1;
			st.push(a);
		}
		
		while (!st.empty()) {
			int next = student[st.peek()] - 1;
			
			if (visited[next] != 1) {
				visited[next] = 1;
				st.push(next);
			} else {
				if (st.search(next) != st.size()) {
					count++;
					st.remove(0);
				} else {
					st.clear();
				}
			}
		}
	}
}
