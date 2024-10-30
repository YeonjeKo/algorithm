import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (i == 0)
                sum = arr[i];
            else
                sum = sum - arr[i - 1];
            while (j < N) {
                if (sum >= S) {
                    min = Math.min(min, j - i + 1);
                    break;                
                }
                j++;
                if (j != N)
                	sum += arr[j];
            }
        }

        if (min == Integer.MAX_VALUE)
            min = 0;

        System.out.print(min);
	}

}
