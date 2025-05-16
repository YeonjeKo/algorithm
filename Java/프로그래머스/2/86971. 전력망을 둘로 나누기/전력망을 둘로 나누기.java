import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> g;
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;
    
    public int solution(int n, int[][] wires) {
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        
        for (int i = 0; i < wires.length; i++) {
            g.get(wires[i][0] - 1).add(wires[i][1] - 1);
            g.get(wires[i][1] - 1).add(wires[i][0] - 1);
        }
        
        visited = new boolean[n];
        
        for (int i = 0; i < wires.length; i++) {
            g.get(wires[i][0] - 1).remove((Integer)(wires[i][1] - 1));
            g.get(wires[i][1] - 1).remove((Integer)(wires[i][0] - 1));
            
            cnt = 1;
            visited = new boolean[n];
            dfs(0);
            
            if (Math.abs(cnt - (n - cnt)) < min)
                min = Math.abs(cnt - (n - cnt));
            
            System.out.println(cnt);
            
            g.get(wires[i][0] - 1).add(wires[i][1] - 1);
            g.get(wires[i][1] - 1).add(wires[i][0] - 1);
        }
        
        return min;
    }
    
    void dfs(int k) {
        if (visited[k])
            return;
        
        visited[k] = true;
        
        for (int i : g.get(k)) {
            if (!visited[i]) {
                cnt++;
                dfs(i);
            }
        }    
    }
}