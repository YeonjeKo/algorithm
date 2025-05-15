import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];
        
        int j = 0;
        int k = 0;
        int l = 0;
        for (int i = 0; i < answers.length; i++) {
            if (j > 4)
                j = 0;
            if (k > 7)
                k = 0;
            if (l > 9)
                l = 0;
            
            if (answers[i] == arr1[j])
                scores[0]++;
            if (answers[i] == arr2[k])
                scores[1]++;
            if (answers[i] == arr3[l])
                scores[2]++;
            
            j++;
            k++;
            l++;
        }
        
        int[] tmp = Arrays.copyOfRange(scores, 0, 3);
        Arrays.sort(tmp);
        int max = tmp[2];
        
        System.out.println(max);
        
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            if (scores[i] == max)
                answer.add(i + 1);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}