import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            for (int j = 6; j <= N; j++) {
                if (arr[j] == 0)
                    arr[j] = arr[j - 5] + arr[j - 1];
            }

            bw.write(String.valueOf(arr[N] + "\n"));
        }
        
        bw.flush();
        bw.close();
        br.close();
	}
}