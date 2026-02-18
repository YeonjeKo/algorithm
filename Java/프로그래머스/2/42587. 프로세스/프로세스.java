import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            q.offer(i);
            pq.offer(priorities[i]);
        }
        
        int count = 0;
        while (!q.isEmpty()) {
            int idx = q.poll();
            int priority = pq.poll();
            
            if (priorities[idx] == priority) {
                count++;
                if (idx == location)
                    return count;
            } else {
                q.offer(idx);
                pq.offer(priority);
            }
        }
        
        return count;
    }
}