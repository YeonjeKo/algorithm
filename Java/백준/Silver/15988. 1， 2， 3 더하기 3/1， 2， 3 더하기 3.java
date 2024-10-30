import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        long[] d = new long[1000001];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = 4; j <= n; j++) {
                if (d[j] == 0) {
                    d[j] = (d[j - 1] + d[j - 2] + d[j - 3]) % 1000000009;
                }
            }
            bw.write(String.valueOf(d[n]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
	}
}