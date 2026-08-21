class Solution {
    public int solution(int n) {
        // int[] nums = new int[n + 1];
        // for (int i = 0; i < nums.length; i++)
        //     nums[i] = i;
        
        int start = 1;
        int end = 1;
        int sum = 1;
        int cnt = 0;
        
        while (end <= n) {
            if (sum == n) {
                cnt++;
                end++;
                sum += end;
            } else if (sum < n) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }
        
        return cnt;
    }
}