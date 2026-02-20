import java.util.*;

class Solution {
    static boolean[][] visited_gb;
    static boolean[][] visited_t;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<int[][]> empty_board = new ArrayList<>();
    static List<int[][]> blocklist = new ArrayList<>();
        
    public int solution(int[][] game_board, int[][] table) {
        visited_gb = new boolean[game_board.length][game_board.length];
        visited_t = new boolean[table.length][table.length];
        
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[i].length; j++) {
                if (game_board[i][j] == 0 && !visited_gb[i][j])
                    bfs(i, j, visited_gb, 0, game_board.length, game_board);
            }
        }
        
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == 1 && !visited_t[i][j])
                    bfs(i, j, visited_t, 1, table.length, table);
            }
        }
        
        int result = 0;
        boolean[] isUsed = new boolean[empty_board.size()];
        for (int i = 0; i < blocklist.size(); i++) {
            int[][] block = blocklist.get(i);
            
            loop_1:
            for (int j = 0; j < empty_board.size(); j++) {
                if (isUsed[j])
                    continue;
                
                for (int k = 0; k < 4; k++) {
                    block = rotate(block);
                    if (Arrays.deepEquals(block, empty_board.get(j))) {
                        result += cnt_block_size(block);
                        isUsed[j] = true;
                        break loop_1;
                    }
                }
            }
        }
        
        return result;
    }
    
    void bfs(int x, int y, boolean[][] visited, int find, int N, int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        List<int[]> arr = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            arr.add(cur);
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == find) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        
        if (find == 0)
            empty_board.add(normalize(arr, find));
        else
            blocklist.add(normalize(arr, find));
    }
    
    int[][] normalize(List<int[]> arr, int flag) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for (int[] tmp : arr) {
            minX = Math.min(tmp[0], minX);
            minY = Math.min(tmp[1], minY);
        }
        
        for (int[] tmp : arr) {
            tmp[0] -= minX;
            tmp[1] -= minY;

            maxX = Math.max(tmp[0], maxX);
            maxY = Math.max(tmp[1], maxY);
        }
        
        int[][] rec = new int[maxX + 1][maxY + 1];
        for (int[] tmp : arr) {
            rec[tmp[0]][tmp[1]] = 1;
        }
        
        return rec;
    }
    
    int[][] rotate(int[][] block) {
        int N = block.length;
        int M = block[0].length;
        
        int[][] rotated = new int[M][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) 
                rotated[j][(N - 1) - i] = block[i][j];
        }
        
        return rotated;
    }
    
    int cnt_block_size(int[][] block) {
        int cnt = 0;
        
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[i].length; j++) {
                if (block[i][j] == 1)
                    cnt++;
            }
        }
        
        return cnt;
    }
}