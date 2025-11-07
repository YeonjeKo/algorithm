import java.util.*;

class Solution {
    
    static int[][] dist = new int[5][5];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][][] map;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        
        map = new char[5][5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = places[i][j].toCharArray();
            }
        }
        
        for (int i = 0; i < 5; i++) { 
            middle:
            for (int j = 0; j < 5; j++) { 
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        Arrays.fill(dist[l], -1);
                    }   
                    
                    if (map[i][j][k] == 'P')
                        bfs(i, j, k);
                    
                    if (check(i, new int[]{j, k})) {
                        answer[i] = 0;
                        break middle;
                    }
                }
                
                for (int k = 0; k < 5; k++) {
                    System.out.print(dist[j][k] + " ");
                }
                System.out.println();
            }
            
        }
        
        return answer;
    }
    
    public void bfs(int k, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        dist[x][y]++;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];
                
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || map[k][nx][ny] == 'X' || dist[nx][ny] != -1)
                    continue;
                
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }
    
    public boolean check(int k, int[] cur) {
        boolean flag = false;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (cur[0] == i && cur[1] == j)
                    continue;
                if (map[k][i][j] == 'P' && (dist[i][j] == 1 || dist[i][j] == 2))
                    flag = true;
            }
        }
        
        return flag;
    }
}