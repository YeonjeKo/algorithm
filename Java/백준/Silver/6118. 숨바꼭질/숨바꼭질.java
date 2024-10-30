import java.util.*;
import java.io.*;

public class Main
{
    public static void putEdge(ArrayList<ArrayList<Integer>> g, int x, int y) {
        g.get(x).add(y);
        g.get(y).add(x);
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            g.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            putEdge(g, n1, n2);
        }

        bfs(1, g, N);
	}

    public static void bfs(int start, ArrayList<ArrayList<Integer>> g, int n) {
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

        int max = Arrays.stream(visited).max().getAsInt();
        ArrayList<Integer> barn = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            if (visited[i] == max) {
                barn.add(i); 
                cnt++;
            }
        }
                
        StringBuilder sb = new StringBuilder();
        sb.append(barn.get(0)).append(" ").append(max).append(" ").append(cnt);

        System.out.println(sb);
    }
    
}