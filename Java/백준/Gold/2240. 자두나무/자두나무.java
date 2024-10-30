import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] tree = new int[T];
        for (int i = 0; i < T; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        } 
    
        int[][][] d = new int[T + 1][W + 1][2];  
        if (tree[0] == 1)
        	d[0][0][0] = 1;
        else
        	d[0][1][1] = 1;
        
        for (int i = 1; i < T; i++) {
        	if (tree[i] == 1)
        		d[i][0][0] = d[i - 1][0][0] + 1;
        	else
        		d[i][0][0] = d[i - 1][0][0];
        	
        	for (int j = 1; j <= W; j++) {
        		if (i < j)
        			break;

        		if (tree[i] == 1) {
        			d[i][j][0] = Math.max(d[i - 1][j][0], d[i - 1][j - 1][1]) + 1;
        			d[i][j][1] = Math.max(d[i - 1][j][1], d[i - 1][j - 1][0]);
        		} else {
        			d[i][j][0] = Math.max(d[i - 1][j][0], d[i - 1][j - 1][1]);
        			d[i][j][1] = Math.max(d[i - 1][j][1], d[i - 1][j - 1][0]) + 1;
        		}
        	}
        }

        int max = 0;
        for (int i = 0; i <= W; i++) {
        	max = Math.max(max, Math.max(d[T - 1][i][0], d[T - 1][i][1]));
        }
        
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
	}
}