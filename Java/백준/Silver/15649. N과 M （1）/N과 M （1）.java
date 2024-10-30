import java.util.*;
import java.io.*;

public class Main
{
    static int[] arr;
    static boolean[] isUsed;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        isUsed = new boolean[N];

        func(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}

    static void func(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++)
                sb.append(arr[i] + " ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                arr[k] = i + 1;
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false;
            }   
        }
    }
}