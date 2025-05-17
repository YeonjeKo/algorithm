import java.util.*;

class Solution {
    static int[][] dist;
    
    public int solution(int[][] maps) {
        dist = new int[maps.length][maps[0].length];
        for (int i = 0; i < maps.length; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        bfs(0, 0, maps);
        
        return dist[maps.length - 1][maps[0].length - 1];
    }
    
    void bfs(int x, int y, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        dist[x][y] = 1;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
            
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && maps[nx][ny] == 1 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nx, ny});   
                }
            }
        }
    }
}