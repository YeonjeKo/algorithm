import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }
        
        int d[] = new int[k + 1];
        d[0] = 1;
        for (int i = 0; i < n; i++) {
        	for (int j = value[i]; j <= k; j++) {
        		d[j] = d[j] + d[j - value[i]];
        	}
        }
        
        bw.write(String.valueOf(d[k]));
        bw.flush();
        bw.close();
        br.close();
	}

}
