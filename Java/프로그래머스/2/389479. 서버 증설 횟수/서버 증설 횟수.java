class Solution {
    public int solution(int[] players, int m, int k) {
        int[] newServer = new int[24];
        int cur = 0;
        
        for (int i = 0; i < 24; i++) {
            if (i >= k && newServer[i - k] > 0)
                cur -= newServer[i - k];
            
            int n = players[i] / m - cur;
            if (players[i] >= m && cur < players[i] / m) {
                for (int j = 0; j < n; j++) {
                    newServer[i]++;
                    cur++;
                }
            }
            System.out.print(cur);
        }
        System.out.println();
        
        int cnt = 0;
        for (int s : newServer) {
            System.out.print(s);
            cnt += s;
        }
        
        return cnt;
    }
}