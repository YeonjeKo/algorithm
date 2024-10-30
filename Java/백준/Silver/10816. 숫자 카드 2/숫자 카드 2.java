import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] card = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(upper_idx(arr[i], card) - lower_idx(arr[i], card)).append(" ");
        }

        System.out.println(sb);
	}

    public static int lower_idx(int target, int[] card) {
        int start = 0;
        int end = card.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (target <= card[mid])
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }

    public static int upper_idx(int target, int[] card) {
        int start = 0;
        int end = card.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (target < card[mid])
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }
}