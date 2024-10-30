import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int j = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            while (j < N) {
                if (arr[j] - arr[i] >= M) {
                    min = Math.min(min, arr[j] - arr[i]);
                    break;                
                }
                j++;
            }
        }

        System.out.print(min);
	}
}