import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("D 1")) {
                if (!pq2.isEmpty()) {
                    int max = pq2.poll();
                    pq1.remove(max);
                }
            } else if (operations[i].equals("D -1")) {
                if (!pq1.isEmpty()) {
                    int min = pq1.poll();
                    pq2.remove(min);
                }
            } else { 
                int n = Integer.parseInt(operations[i].substring(2));
                
                pq1.offer(n);
                pq2.offer(n);
            }
        }
        
        if (pq1.isEmpty() || pq2.isEmpty()) {
            return new int[] {0, 0};
        } else {
            return new int[] {pq2.poll(), pq1.poll()};
        }
    }
}