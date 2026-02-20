import java.util.*;

class Solution {
    boolean[] visited;
    String[] result;
    boolean flag = false;
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0]))
                return o1[1].compareTo(o2[1]);
            else
                return o1[0].compareTo(o2[0]);
        });
        
        visited = new boolean[tickets.length];
        int[] index = new int[tickets.length];
        
        dfs(tickets, 0, "ICN", index);
        
        return result;
    }
    
    void dfs(String[][] tickets, int depth, String now, int[] index) {
        if (flag)
            return;
        
        if (depth == tickets.length) {
            result = new String[tickets.length + 1];
            result[0] = "ICN";
            for (int i = 1; i < result.length; i++) {
                result[i] = tickets[index[i - 1]][1];
            }
            flag = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i]) {
                if (tickets[i][0].equals(now)) {
                    visited[i] = true;
                    index[depth] = i;
                    dfs(tickets, depth + 1, tickets[i][1], index);
                    visited[i] = false;
                }
                    
            }
        }
    }
}