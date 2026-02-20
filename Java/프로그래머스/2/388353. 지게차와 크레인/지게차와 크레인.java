import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    char[][] containers;
    boolean[][] visited;
    int N, M;
    
    public int solution(String[] storage, String[] requests) {
        N = storage.length + 2;
        M = storage[0].length() + 2;
        containers = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 || j == 0 || i == N - 1 || j == M - 1)
                    containers[i][j] = ' ';
                else
                    containers[i][j] = storage[i - 1].charAt(j - 1);
            }
        }
        
        for (int i = 0; i < requests.length; i++) {
            visited = new boolean[N][M];
            if (requests[i].length() == 2)
                crane(requests[i].charAt(0));
            else
                bfs(requests[i].charAt(0), 0, 0);
        }
        
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (containers[i][j] != ' ')
                    cnt++;
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(containers[i][j]);
            }
            System.out.println();
        }
        
        return cnt;
    }
    
    void bfs(char c, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new int[] {x, y});
        
        List<int[]> removeList = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
            
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (containers[nx][ny] == ' ') {
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    }
                    if (containers[nx][ny] == c) {
                        visited[nx][ny] = true;
                        removeList.add(new int[] {nx, ny});
                    }
                }
            }
        }
        
        for (int[] p : removeList) {
            containers[p[0]][p[1]] = ' ';
        }
    }
    
    void crane(char c) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (containers[i][j] == c)
                    containers[i][j] = ' ';
            }
        }
    }
}