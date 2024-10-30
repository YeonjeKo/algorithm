import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            
            if (i == 0)
                arr[i] = tmp;
            else {
                if (arr[i - 1] < 0)
                    arr[i] = tmp;
                else
                    arr[i] = arr[i - 1] + tmp;
            }

            if (max < arr[i])
                max = arr[i];
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
	}
}