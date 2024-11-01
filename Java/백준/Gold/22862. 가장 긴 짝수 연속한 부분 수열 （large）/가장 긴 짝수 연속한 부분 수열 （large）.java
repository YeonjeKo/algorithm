import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] S = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int j = 0;
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                if (S[i] % 2 != 0)
                	cnt++;
            }
            else {
                if (S[i - 1] % 2 != 0)
                	cnt--;
            }
           
            while (j < N) {
                if (cnt > K) {
                	max = Math.max(j - i - (cnt - 1), max);
                    break;
                }
                j++;
                if (j != N) {
                	if (S[j] % 2 != 0)
                		cnt++;
                }
            }
            
            if (cnt <= K)
            	max = Math.max(j - i - cnt, max);
        }
        
        if (max < 0)
        	max = 0;

        System.out.println(max);
	}

}
