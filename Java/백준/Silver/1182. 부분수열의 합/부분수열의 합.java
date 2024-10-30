import java.util.*;
import java.io.*;

public class Main
{
    static int[] arr;
    static int N, S;
    static int cnt = 0;
 
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);
        
        if (S == 0)
            cnt--;
        
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
	}

    static void func(int k, int sum) {
        if (k == N) {
            if (sum == S)
                cnt++;
            return;
        }

        func(k + 1, sum);
        func(k + 1, sum + arr[k]);
    }
}