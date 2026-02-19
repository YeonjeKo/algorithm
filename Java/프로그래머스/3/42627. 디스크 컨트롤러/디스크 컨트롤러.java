import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        int count = 0;
        int time = 0;
        int result = 0;
        int idx = 0;
        while (count < jobs.length) {
            for (int i = idx; i < jobs.length; i++) {
                if (jobs[i][0] <= time) {
                    pq.offer(jobs[i]);
                    idx = i + 1;
                }
                else
                    break;
            }
            
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                result += time - job[0] + job[1];
                time += job[1];
                count++;
            } else {
                time++;
            }
        }
        
        return result / jobs.length;
    }
}