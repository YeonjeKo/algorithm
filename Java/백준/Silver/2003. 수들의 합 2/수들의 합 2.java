import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int j = 0;
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0)
                sum = A[i];
            else
                sum -= A[i - 1];

            while (j < N) {
                if (sum >= M) {
                    if (sum == M)
                        cnt++;
                    break;
                }
                
                j++;
                if (j != N)
                    sum += A[j];
            }
        }

        System.out.println(cnt);
	}
}