import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> g = new ArrayList<>();
    static int[] dist;
    
    public int solution(int n, int[][] edge) {
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            g.get(edge[i][0] - 1).add(edge[i][1] - 1);
            g.get(edge[i][1] - 1).add(edge[i][0] - 1);
        }
        
        dist = new int[n];
        Arrays.fill(dist, -1);
        
        bfs(0);
        
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] > max) {
                max = dist[i];
                cnt = 1;
            } else if (dist[i] == max) {
                cnt++;
            }
            
            System.out.println(dist[i]);
        }
        
        return cnt;
    }
    
    void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        dist[node] = 1;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : g.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}