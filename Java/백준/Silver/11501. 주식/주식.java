import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] stock = new int[N];
            for (int j = 0; j < N; j++) {
                stock[j] = Integer.parseInt(st.nextToken());
            }
           
            int max = stock[N - 1];
            int now = 0;
            int cnt = 0;
            long profit = 0;
            for (int j = N - 1; j >= 0; j--) {
            	if (stock[j] < max) {
            		now += stock[j];
            		cnt++;
            		if (j == 0)
            			profit += cnt * max - now;
            
            	} else {
            		profit += cnt * max - now;
            		max = stock[j];
            		cnt = 0;
            		now = 0;
            	}
            }

            sb.append(profit + "\n");
        }

        System.out.print(sb);
	}

}
