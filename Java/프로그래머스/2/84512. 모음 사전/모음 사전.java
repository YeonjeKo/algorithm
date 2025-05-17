import java.util.*;

class Solution {
    static char[] c = {'A', 'E', 'I', 'O', 'U'};
    static char[] arr;
    static ArrayList<String> sArr = new ArrayList<>();
    
    public int solution(String word) {
        for (int i = 1; i <= 5; i++) {
            arr = new char[5];
            rep_permutation(0, i);
        }
        
        Collections.sort(sArr);
        
        // for (String s : sArr) {
        //     System.out.println(s);
        // }
        
        return sArr.indexOf(word) + 1;
    }
    
    void rep_permutation(int k, int n) {
        if (k == n) {
            String s = new String(arr, 0, n);
            sArr.add(s);
            //System.out.println(s);
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            arr[k] = c[i];
            rep_permutation(k + 1, n);
        }
    }
}