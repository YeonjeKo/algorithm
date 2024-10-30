import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] co = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            co[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = Arrays.stream(co).distinct().toArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(lower_idx(co[i], arr)).append(" ");
        }

        System.out.println(sb);
	}

    public static int lower_idx(int target, int[] arr) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (target <= arr[mid])
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }
}