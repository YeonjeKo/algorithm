class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width = -1;
        int height = -1;
        
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            int y_width = -1;
            
            if (yellow % i == 0)
                y_width = yellow / i;
            
            if ((y_width + 2) * 2 + i * 2 == brown)
            {
                width = y_width + 2;
                height = i + 2;
            }
        }
        
        answer[0] = width;
        answer[1] = height;
        
        return answer;
    }
}