import java.util.*;

class Solution {
    static boolean[] visited;
    static int n;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                cnt++;
            }
        }
        
        return cnt;
    }
    
    void bfs(int node, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i = 0; i < computers.length; i++) {
                if (!visited[i] && computers[cur][i] == 1) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}