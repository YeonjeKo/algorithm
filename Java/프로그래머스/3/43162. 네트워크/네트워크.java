class Solution {
    
    static boolean[] visited;
    static int N;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        N = n;
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                cnt++;
            }
        }
        
        return cnt;
    }
    
    public void dfs(int n, int[][] computers) {
        visited[n] = true;
        
        for (int i = 0; i < N; i++) {
            if (!visited[i] && computers[n][i] == 1)
                dfs(i, computers);
        }
    }
}