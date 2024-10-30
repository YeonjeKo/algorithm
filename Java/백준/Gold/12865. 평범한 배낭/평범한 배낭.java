import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] W = new int[N];
        int[] V = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[][] d = new int[N][K + 1];
        for (int i = 0; i < N; i++) {
        	for (int j = 1; j <= K; j++) {
        		if (i == 0) {
        			if (j - W[i] >= 0)
        				d[i][j] = V[i];
        			else
        				d[i][j] = 0;
        			continue;
        		}
        		
        		if (j - W[i] >= 0) {
        			d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - W[i]] + V[i]);
        		} else {
        			d[i][j] = d[i - 1][j];
        		}
        	}
        }

        System.out.println(d[N - 1][K]);
	}

}
