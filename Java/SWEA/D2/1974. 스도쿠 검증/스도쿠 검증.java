import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static int[][] map;
    static int[] num;
    static int flag = 1;
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T  = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			map = new int[9][9];
            num = new int[10];
            flag = 1;
            
            for (int i = 0; i < 9; i++) {
             	for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
                    num[map[i][j]]++;
                    if (j == 8) {
                        check();
                        Arrays.fill(num, 0);
                        if (flag == 0)
                            break;
                    } 
                }   
            }
            
            if (flag == 1) {
             	for (int j = 0; j < 9; j++) {
                 	for (int i = 0; i < 9; i++) {
                        num[map[i][j]]++;
                     	if (i == 8) {
                         	check();
                            Arrays.fill(num, 0);
                            if (flag == 0)
                                break;
                        }
                    }
                }
            }
            
            if (flag == 1) {
             	for (int i = 0; i < 9; i++) {
                 	for (int j = 0; j < 9; j++) {
                     	if (i % 3 == 0 && j % 3 == 0) {
                            check2(i, j);
                            Arrays.fill(num, 0);
                            if (flag == 0)
                                break;
                        }
                    }
                }
            }
                
            System.out.println("#" + test_case + " " + flag);
		}
	}
    
    static void check() {
        for (int i = 1; i < 10; i++) {
         	if (num[i] != 1) {
             	flag = 0;
                return;
            }
        }
    }
    
    static void check2(int x, int y) {
     	for (int i = 0; i < 3; i++) {
         	for (int j = 0; j < 3; j++) {
             	num[map[i][j]]++;
            }
        }
        
        check();
    }
}