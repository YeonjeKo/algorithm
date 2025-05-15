import java.util.*;

class Solution {
    
    static boolean[] isUsed;
    static char[] cArr;
    static List<Integer> nArr;
    
    public int solution(String numbers) {
        
        nArr = new ArrayList<>();
        for (int i = 0; i < numbers.length(); i++) {
            isUsed = new boolean[numbers.length()];
            cArr = new char[i + 1];
            func(0, i + 1, numbers);
        }
        
        int[] newList = nArr.stream().distinct().mapToInt(i -> i).toArray();
        
        int sum = 0;
        for (int i = 0; i < newList.length; i++) {
            if (find(newList[i]))
                sum++;
            
            //System.out.println(newList[i]);
        }
        
        return sum;
    }
    
    void func(int k, int N, String s) {
        if (k == N) {
            int sum = 0;
            for (int i = cArr.length - 1; i >= 0; i--) {
                sum += (cArr[i] - '0') * Math.pow(10, i);
                System.out.println(cArr[i] - '0');
            }
            nArr.add(sum);
            //System.out.println(sum);
            
            return;
        }      
            
        for (int i = 0; i < s.length(); i++) {
            if (!isUsed[i]) {
                cArr[k] = s.charAt(i);
                isUsed[i] = true;
                func(k + 1, N, s);
                isUsed[i] = false;
            }
        }
    }
    
    boolean find(int n) {
        if (n <= 1)
            return false;
        
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        
        //System.out.println(n);
        return true;
    }
}