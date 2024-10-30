import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] pn = new long[N + 1];
        pn[1] = 1;
        if (N > 1)
            pn[2] = 1;
        for (int i = 3; i <= N; i++) {
            pn[i] = pn[i - 2] + pn[i - 1];
        }

        bw.write(String.valueOf(pn[N]));
        bw.flush();
        bw.close();
        br.close();
	}
}