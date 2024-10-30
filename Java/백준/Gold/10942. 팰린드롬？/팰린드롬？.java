import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        int[][] d = new int[N][N];
        
        for (int i = 0; i < N; i++)
        	Arrays.fill(d[i], -1);
        
        for (int i = 0; i < N; i++) {
        	d[i][i] = 1;
        	if (i == N - 1)
        		continue;
        	if (i < N && arr[i] == arr[i + 1]) {
        		d[i][i + 1] = 1;
        	}
        }
        
        for (int j = 0; j < N; j++) {
        	for (int i = 0; i <= j; i++) {
        		if (d[i][j] != -1)
        			continue;
        		if (arr[i] == arr[j] && d[i + 1][j - 1] == 1)
        			d[i][j] = 1;
        		else
        			d[i][j] = 0;
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            sb.append(d[x - 1][y - 1] + "\n");
        }
        
        System.out.println(sb);
	}

}
