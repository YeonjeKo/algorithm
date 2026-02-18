import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(')
                st.push(c[i]);
            else {
                if (st.isEmpty())
                    return false;
                
                if (st.peek() == '(')
                    st.pop();
            }
        }
        
        if (st.isEmpty())
            return true;
        else
            return false;
    }
}