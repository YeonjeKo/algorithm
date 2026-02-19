import java.util.*;

class Solution {
    static int count = 0;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        char[] nums = numbers.toCharArray();
        for (int i = 1; i <= nums.length; i++) {
            char[] result = new char[i];
            boolean[] visited = new boolean[nums.length];
            permutation(nums, result, visited, 0, i);
        }
        
        return set.size();
    }
    
    void permutation(char[] nums, char[] result, boolean[] visited, int depth, int k) {
        if (depth == k) {
            String str = new String(result);
            int n = Integer.parseInt(str);
            
            if (isPrime(n))
                set.add(n);
            
            System.out.println(n);
            
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = nums[i];
                permutation(nums, result, visited, depth + 1, k);
                visited[i] = false;
            }
        }
    }
    
    boolean isPrime(int n) {
        if (n == 0 || n == 1)
            return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }  
        }
        
        return true;
    }
}