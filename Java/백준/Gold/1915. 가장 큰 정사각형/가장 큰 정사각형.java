import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = str[j] - '0';
            }
        }
        
        int[][] d = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < m; j++) {
        		if (map[i][j] == 1) {
        			if (i == 0 || j == 0) 
        				d[i][j] = 1;
        			else {
        				d[i][j] = Math.min(d[i - 1][j - 1], Math.min(d[i - 1][j], d[i][j - 1])) + 1;
        			}
        			if (max <= d[i][j])
        				max = d[i][j];
        		}
        	}
        }
        
        System.out.println(max * max);
	}

}
