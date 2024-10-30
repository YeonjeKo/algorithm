import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lan = new int[K];

        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(lan);

        System.out.println(binary_search((long)lan[K - 1], N, lan));
	}

    public static long binary_search(long end, int target, int[] lan) {
        long start = 0;
        
        while (start < end) {
            long mid = (start + end + 1) / 2;

            long sum = 0;
            for (int i = 0; i < lan.length; i++) {
                sum += lan[i] / mid;
            }

            if (sum < target)
                end = mid - 1;
            else
                start = mid;
        }

        return start;
    }
}