import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int[] card;
    static int max = Integer.MIN_VALUE;
    static int n;
    
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            char[] tmp = sc.next().toCharArray();
			card = new int[tmp.length];
			for (int i  = 0; i < card.length; i++) {
                card[i] = tmp[i] - '0';
            }
               
            n = sc.nextInt();
            if (n > card.length)
                n = card.length;
            
            
            max = Integer.MIN_VALUE;
            dfs(0, 0);
            
            System.out.println("#" + test_case + " " + max);
		}
	}
    
    public static void dfs(int depth, int start) {
        if (depth == n) {
            String snum = "";
         	 for (int i = 0; i < card.length; i++) {
             	snum += Integer.toString(card[i]);  
             }
            
            int num = Integer.parseInt(snum);
            if (max < num)
                max = num;
            
            return;
        }
        
        for (int i = start; i < card.length; i++) {
            for (int j = i + 1; j <card.length; j++) { 
            	swap(i, j);
                dfs(depth + 1, i);
                swap(i, j);
            }
        }
    }
    
    public static void swap(int i, int j) {
		int tmp = card[i];
        card[i] = card[j];
        card[j] = tmp;
             
        return;
    }
}