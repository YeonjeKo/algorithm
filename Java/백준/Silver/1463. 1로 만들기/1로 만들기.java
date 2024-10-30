import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N + 1];
        d[1] = 0;
        for (int i = 2; i < N + 1; i++) {
            int tmp1 = Integer.MAX_VALUE, tmp2 = Integer.MAX_VALUE, tmp3 = Integer.MAX_VALUE;
            if (i % 3 == 0)
                tmp1 = d[i / 3] + 1;
            if (i % 2 == 0)
                tmp2 = d[i / 2] + 1;
            tmp3 = d[i - 1] + 1;

            d[i] = Math.min(tmp1, (Math.min(tmp2, tmp3)));
        }

        bw.write(String.valueOf(d[N]));
        bw.flush();
        bw.close();
        br.close();
	}
}