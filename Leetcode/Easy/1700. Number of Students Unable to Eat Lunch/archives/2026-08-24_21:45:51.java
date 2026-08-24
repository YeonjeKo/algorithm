class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        
        int circular = 0;
        int square = 0;
        for (int i = 0; i < students.length; i++) {
            q.offer(students[i]);

            if (students[i] == 1)
                square++;
            else
                circular++;
        }

        int i = 0;
        while (i < sandwiches.length) {
            if (sandwiches[i] == q.peek()) {
                i++;

                int cur = q.poll();
                if (cur == 1)
                    square--;
                else
                    circular--;
            } else {
                if ((sandwiches[i] == 1 && square == 0) || (sandwiches[i] == 0 && circular == 0))
                    break;

                q.offer(q.poll());
            }
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            q.poll();
            cnt++;
        }

        return cnt;
    }
}