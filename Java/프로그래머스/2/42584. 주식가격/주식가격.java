import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> st = new Stack<>();
        
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (!st.isEmpty()) {
                while (!st.isEmpty() && prices[st.peek()] > prices[i]) {
                    int idx = st.pop();
                    result[idx] = i - idx;
                } 
            } 
            st.push(i);
        }
        
        while (!st.isEmpty()) {
            int idx = st.pop();
            result[idx] = prices.length - 1 - idx;
        }
        
        return result;
    }
}