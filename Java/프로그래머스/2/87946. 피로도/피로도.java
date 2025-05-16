class Solution {
    static boolean[] isVisited;
    static int max = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        isVisited = new boolean[dungeons.length];
        
        func(0, k, dungeons);
        
        return max;
    }
    
    void func(int n, int k, int[][] dungeons) {
        if (n == dungeons.length) {
            if (max < n)
                max = n;
            return;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i]) {
                if (k >= dungeons[i][0]) {
                    isVisited[i] = true;
                    func(n + 1, k - dungeons[i][1], dungeons);
                    isVisited[i] = false;
                }
                else {
                    if (max < n)
                        max = n;
                }
            }
        }
    }
}