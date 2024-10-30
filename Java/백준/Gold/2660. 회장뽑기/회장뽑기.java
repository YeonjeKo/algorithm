import java.util.*;
import java.io.*;

public class Main {
	public static void putEdge(ArrayList<ArrayList<Integer>> g, int x, int y) {
        g.get(x).add(y);
        g.get(y).add(x);
    }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if (n1 == -1)
                break;
            
            putEdge(g, n1, n2);
        }
        
        int min = Integer.MAX_VALUE;
        
        int[] volunteers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
        	int tmp = bfs(i, g , n);
        	volunteers[i] = tmp;
        	if (min >= tmp && tmp != 0) {
        		min = tmp;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
        	if (volunteers[i] == min) {
        		cnt++;
        		sb.append(i + " ");
        	}
        }
        
        StringBuilder rslt = new StringBuilder();
        rslt.append(min + " " + cnt + "\n" + sb.toString());
        System.out.print(rslt);
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
        
        int score = Arrays.stream(visited).max().getAsInt();
        return score;
    }

}
