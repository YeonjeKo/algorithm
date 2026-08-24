class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<Integer>();

        int i = 0;
        int j = 0;
        while (i < pushed.length) {
            st.push(pushed[i]);
            if (pushed[i] == popped[j]) {
                while (!st.isEmpty() && st.peek() == popped[j]) {
                    st.pop();
                    j++;
                }
            } 
            i++;
        }

        if (st.isEmpty())
            return true;
        else
            return false;
    }
}