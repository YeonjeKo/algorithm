import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        long start = 1;
        long end = tree[N - 1];
        long max = 0;
        while(end >= start) {
            long mid = (start + end) / 2;
            
            long sum = 0;
            for (int i = 0; i < N; i++) {
                long tmp = tree[i] - mid;
                if (tmp > 0)
                    sum += tmp;
            }

            if (sum >= M) {
                start = mid + 1;
                max = Math.max(max, mid);
            } else {
                end = mid - 1;
            }
        }

        System.out.println(max);
	}
}