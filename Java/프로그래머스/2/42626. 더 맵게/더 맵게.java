import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        int count = 0;
        while (pq.size() >= 2) {
            int food1 = pq.poll();
            if (food1 < K) {
                int food2 = pq.poll();
                int mix = food1 + food2 * 2;
                pq.offer(mix);
                count++;
            }
            else
                break;
        }
        
        if (pq.peek() < K)
            count = -1;
        
        return count;
    }
}