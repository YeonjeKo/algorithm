import java.util.*;

class Solution {
    static boolean[] visited;
    static List<List<Integer>> g;
    static int cnt;
    
    public int solution(int n, int[][] wires) {
        g = new ArrayList<>();
        
        for (int i = 0; i <= n; i++)
            g.add(new ArrayList<>());
        
        for (int i = 0; i < wires.length; i++) {
            g.get(wires[i][0]).add(wires[i][1]);
            g.get(wires[i][1]).add(wires[i][0]);
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            visited = new boolean[n + 1];
            cnt = 1;
            
            g.get(wires[i][0]).remove((Integer)wires[i][1]);
            g.get(wires[i][1]).remove((Integer)wires[i][0]);
            
            dfs(wires, 1);
            
            min = Math.min(min, Math.abs(cnt - (n - cnt)));

            g.get(wires[i][0]).add(wires[i][1]);
            g.get(wires[i][1]).add(wires[i][0]);
        }
        
        return min;
    }
    
    void dfs(int[][] wires, int k) {
        visited[k] = true;
        
        for (int next : g.get(k)) {
            if (!visited[next]) {
                cnt++;
                dfs(wires, next);
            }
        }
    }
}