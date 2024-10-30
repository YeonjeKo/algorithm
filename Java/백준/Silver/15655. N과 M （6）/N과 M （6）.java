import java.util.*;
import java.io.*;

public class Main
{
    static int[] a, arr;
    static boolean[] isUsed;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N];
        arr = new int[M];
        isUsed = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        func(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}

    static void func(int k) {
        if (k == arr.length) {
            for (int i = 0; i < arr.length; i++)
                sb.append(a[arr[i]] + " ");
            sb.append("\n");
            return;
        }

        int start = 0;
        if (k != 0)
            start = arr[k - 1] + 1;

        for (int i = start; i < N; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false;
            }
        }
    }
}