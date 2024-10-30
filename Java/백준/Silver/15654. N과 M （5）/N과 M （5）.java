import java.util.*;
import java.io.*;

public class Main
{
    static int[] arr, a;
    static boolean[] isUsed;
    static int N, M;
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        isUsed = new boolean[N];
        
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
                sb.append(arr[i] + " ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
            	arr[k] = a[i];
            	isUsed[i] = true;
            	func(k + 1);
            	isUsed[i] = false;
            }
        }
    }
}