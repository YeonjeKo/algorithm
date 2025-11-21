import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
    static int[][] map = new int[100][100];
    static int[] dx = {0, 0, 1};
    static int[] dy = {-1, 1, 0};
    static boolean flag = false;
    static boolean[][] visited = new boolean[100][100];
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int tNum = sc.nextInt();
            
            for (int i = 0; i < 100; i++) {
             	for (int j = 0; j < 100; j++) {
                	map[i][j] = sc.nextInt();    
                }
            }
            
            int result = 0;
            flag = false;
            
            for (int i = 0; i < 100; i++) {
             	if (map[0][i] == 1) {
                    for (int j = 0; j < 100; j++)
                		Arrays.fill(visited[j], false);
                    visited[0][i] = true;
                 	dfs(0, i);
                    if (flag) {
                        result = i;
                        break;
                    } 
                }
            }

            System.out.println("#" + tNum + " " + result);
		}
	}
    
    static void dfs(int x, int y) {
        //System.out.println("x: " + x + " y: " + y);
        
        if (x == 99) {
            if (map[x][y] == 2)
                flag = true;
            return;
        }	
        
        for (int i = 0; i < 3; i++) {
         	int nx = x + dx[i];
            int ny = y + dy[i];
            
            if ( nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || map[nx][ny] == 0 || visited[nx][ny])
                continue;
            else {
                visited[nx][ny] = true;
                dfs(nx, ny);
                return;
            }
        }
    }
}