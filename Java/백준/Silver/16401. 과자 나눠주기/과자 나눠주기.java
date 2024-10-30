import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] snack = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snack);
        
        int start = 1;
        int end = snack[N - 1];
        int max = 0;
        while (end >= start) {
            int mid = (end + start) / 2;

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += snack[i] / mid;
            }

            if (cnt >= M) {
                start = mid + 1;
                max = Math.max(max, mid);
            } else {
                end = mid - 1;
            }
        }

        System.out.println(max);
            
	}
}