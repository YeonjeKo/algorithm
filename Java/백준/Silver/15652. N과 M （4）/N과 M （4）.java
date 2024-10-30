import java.util.*;
import java.io.*;

public class Main
{
    static int[] arr;
    static int N, M;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        func(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}

    static void func(int k) {
        if (k == arr.length) {
            for (int i = 0; i < arr.length; i++)
                sb.append(arr[i] + " ");
            sb.append("\n");
            return;
        }

        int start = 1;
        if (k != 0)
            start = arr[k - 1];


        for (int i = start; i <= N; i++) {
            arr[k] = i;
            func(k + 1);
        }
    }
}