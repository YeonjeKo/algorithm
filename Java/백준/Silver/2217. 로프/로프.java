import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] rope = new Integer[N];
        
        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope, Collections.reverseOrder());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = rope[i] * (i + 1);
        }

        Arrays.sort(arr);

        System.out.println(arr[N - 1]);
	}
}