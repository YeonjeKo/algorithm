import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] cnt = new int[200001]; 

        int j = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
        	if (i == 0)
                cnt[arr[i]] = 1;
            else
                cnt[arr[i - 1]]--;
        	
            while (j < N) {
                if (cnt[arr[j]] > K) {
                    max = Math.max(max, j - i);
                    break;                
                }
                j++;
                if (j != N)
                	cnt[arr[j]]++;
                else
                	max = Math.max(max, j - i);
            }
        }

        System.out.print(max);
	}

}
