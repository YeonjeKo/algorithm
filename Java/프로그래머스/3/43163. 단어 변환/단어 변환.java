import java.util.*;

class Solution {
    static int[] dist;
    static ArrayList<String> list;
    
    public int solution(String begin, String target, String[] words) {
        list = new ArrayList<>(Arrays.asList(words));
        
        list.remove(begin);
        
        int tmp = list.indexOf(target);
        if (tmp == -1)
            return 0;
        
        dist = new int[list.size()];
        Arrays.fill(dist, -1);
    
        bfs(begin);

        return dist[tmp];
    }
    
    void bfs(String node) {
        Queue<String> q = new LinkedList<>();
        q.offer(node);
        if (list.indexOf(node) != -1)
            dist[list.indexOf(node)] = 1;
        
        while (!q.isEmpty()) {
            String cur = q.poll();
            int curIdx = list.indexOf(cur);
            
            for (int i = 0; i < list.size(); i++) {
                if (dist[i] == -1 && compareString(cur, list.get(i))) {
                    if (curIdx == -1)
                        dist[i] = 1;
                    else
                        dist[i] = dist[curIdx] + 1;
                    q.offer(list.get(i));
                }
            }
        }
    }
    
    boolean compareString(String s1, String s2) {
        int cnt = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i])
                cnt++;
        }
        
        if (cnt == 1)
            return true;
        else
            return false;
    }
}