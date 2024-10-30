import java.io.*;
import java.util.*;

public class Main
{
    static int N, M;
    static int[] arr1, arr2;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr1 = new int[N];
        arr2 = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        func(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}

    static void func(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) 
                sb.append(arr1[arr2[i]] + " ");
            sb.append("\n");
            return;
        }

        int start = 0;
        if (k != 0)
            start = arr2[k - 1];

        for (int i = start; i < N; i++) {
            arr2[k] = i;
            func(k + 1);
        }

    }
}