import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb;
        int min = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            String target = s.substring(0, i);
            int count = 1;
            sb = new StringBuilder();
            for (int j = i; j < s.length(); j += i) {
                int end = Math.min(j + i, s.length());
                String next = s.substring(j, end);
                
                if (target.equals(next)) {
                    count++;
                } else {
                    if (count > 1)
                        sb.append(count).append(target);
                    else
                        sb.append(target);
                    
                    count = 1;
                    target = next;
                }
            }            
            
            if (count > 1)
                sb.append(count).append(target);
            else
                sb.append(target);
            
            String result = sb.toString();
            //System.out.println(result);
            min = Math.min(result.length(), min);
        }
        
        return min;
    }
}