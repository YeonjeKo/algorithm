import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] block = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }
        
        int cnt = 0;
        for (int i = 1; i < W - 1; i++) {
        	int lmax = -1;
        	int rmax = -1;
        	
        	for (int j = 0; j <= i - 1; j++) {
        		if (block[j] > block[i] && lmax <= block[j])
        			lmax = block[j];
        	}
        	
        	for (int j = i + 1; j < W; j++) {
        		if (block[j] > block[i] && rmax <= block[j])
        			rmax = block[j];
        	}
        	
        	int max = Math.min(lmax, rmax);
        	if (max != -1 && (max - block[i] > 0))
        		cnt += max - block[i];
        	
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        
	}

}
