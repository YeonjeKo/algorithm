import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static int V, E;
    
    static class Node implements Comparable<Node> {
     	int to, weight;
        
        Node (int t, int w) {
            to = t;
            weight = w;
        }
        
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    
    static List<List<Node>> g;
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			V = sc.nextInt();
            E = sc.nextInt();
            g = new ArrayList<>();
            
            for (int i = 0; i <= V; i++)
                g.add(new ArrayList<>());
            
            for (int i = 0; i < E; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
             	g.get(a).add(new Node(b, c));
                g.get(b).add(new Node(a, c));
            }
			
            long result = prim(1);
            
            System.out.println("#" + test_case + " " + result);
		}
	}
    
    static long prim(int start) {
     	boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.offer(new Node(start, 0));
        long total = 0;
        
        while (!pq.isEmpty()) {
         	Node cur = pq.poll();
            
            if (visited[cur.to])
                continue;
            
            visited[cur.to] = true;
            total += cur.weight;
            
            for (Node next : g.get(cur.to)) {
                if (!visited[next.to])
                    pq.offer(next);
            }
        }
        
        return total;
    }
}