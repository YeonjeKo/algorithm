import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N + 1];
        int[] pre = new int[N + 1];
        d[1] = 0;
        pre[1] = 0;
        for (int i = 2; i < N + 1; i++) {
            int tmp1 = Integer.MAX_VALUE, tmp2 = Integer.MAX_VALUE, tmp3 = Integer.MAX_VALUE;
            if (i % 3 == 0)
                tmp1 = d[i / 3] + 1;
            if (i % 2 == 0)
                tmp2 = d[i / 2] + 1;
            tmp3 = d[i - 1] + 1;

            d[i] = Math.min(tmp1, (Math.min(tmp2, tmp3)));
            if (d[i] == tmp1)
                pre[i] = i / 3;
            else if (d[i] == tmp2)
                pre[i] = i / 2;
            else 
                pre[i] = i - 1;
        }

        bw.write(String.valueOf(d[N]) + "\n");
        int i = N;
        bw.write(String.valueOf(N) + " ");
        while (i != 1) {
            bw.write(String.valueOf(pre[i]) + " ");
            i = pre[i];
        }

        bw.flush();
        bw.close();
        br.close();
	}
}