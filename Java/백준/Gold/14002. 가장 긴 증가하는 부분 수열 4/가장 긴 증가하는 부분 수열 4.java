import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] d = new int[N];
        int[] pre = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            d[i] = 1;
        }
        
        int max = 1;
        int maxIdx = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                	if (d[i] < d[j] + 1) {
                		d[i] = d[j] + 1;
                		pre[i] = j;
                	}
                }
            }

            if (max < d[i]) {
                max = d[i];
                maxIdx = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[maxIdx]);
        for (int i = 1; i < max; i++) {
        	sb.insert(0, arr[pre[maxIdx]] + " ");
        	maxIdx = pre[maxIdx];
        }
        
        bw.write(String.valueOf(max) + "\n" + sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}

}
