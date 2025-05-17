import java.util.*;

class Solution {
    static int[][] map;
    static int[][] dist;
    static int maxX = Integer.MIN_VALUE;
    static int maxY = Integer.MIN_VALUE;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[51 * 2][51 * 2];
        
        for (int i = 0; i < rectangle.length; i++) {
            if (maxX < Math.max(rectangle[i][0], rectangle[i][2]))
                maxX = Math.max(rectangle[i][0], rectangle[i][2]);
            if (maxY < Math.max(rectangle[i][1], rectangle[i][3]))
                maxY = Math.max(rectangle[i][1], rectangle[i][3]);
            
            fill(rectangle[i][0] * 2, rectangle[i][1] * 2, rectangle[i][2] * 2, rectangle[i][3] * 2);
        }
        
        for (int i = 0; i < rectangle.length; i++)
            remove(rectangle[i][0] * 2, rectangle[i][1] * 2, rectangle[i][2] * 2, rectangle[i][3] * 2);
        
        dist = new int[(maxX + 1) * 2][(maxY + 1) * 2];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        bfs(characterX * 2, characterY * 2);
        
        return dist[itemX * 2][itemY * 2] / 2;
    }
    
    void fill(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                map[i][j] = 1;
            }
        }
    }
    
    void remove(int x1, int y1, int x2, int y2) {
        for (int i = x1 + 1; i < x2; i++) {
            for (int j = y1 + 1; j < y2; j++)
                map[i][j] = 0;
        }
    }
    
    void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        dist[x][y] = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                
                if (nx > 0 && nx <= maxX * 2 && ny > 0 && ny <= maxY * 2 && dist[nx][ny] == -1 && map[nx][ny] == 1) {
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}