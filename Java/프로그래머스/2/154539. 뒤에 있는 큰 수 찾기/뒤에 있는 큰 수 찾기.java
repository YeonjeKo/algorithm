import java.util.*;

class Solution {
    
    static class Pair {
        int value;
        int idx;
        
        Pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }
    
    public int[] solution(int[] numbers) {
        Stack<Pair> st = new Stack<>();
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            // if (st.isEmpty() || st.peek().value >= numbers[i])
            //     st.push(new Pair(numbers[i], i));
            // else {
            //     Pair cur = st.pop();
            //     answer[cur.idx] = numbers[i];
            // }
            while (!st.isEmpty() && st.peek().value < numbers[i]) {
                Pair cur = st.pop();
                answer[cur.idx] = numbers[i];
            }
            st.push(new Pair(numbers[i], i));
        }
        
        while (!st.isEmpty()) {
            Pair cur = st.pop();
            answer[cur.idx] = -1;
        }
        
        return answer;
    }
}