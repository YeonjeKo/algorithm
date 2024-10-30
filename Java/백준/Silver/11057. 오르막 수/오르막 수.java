import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[][] d = new long[N][10];

        long sum = 0;
        long pre_sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0) 
                    d[i][j] = 1;
                else {
                    if (j == 0)
                        d[i][j] = pre_sum;
                    else 
                        d[i][j] = (d[i][j - 1] - d[i - 1][j - 1] + 10007) % 10007;
                }
                sum = (sum + d[i][j]) % 10007;
            }
            pre_sum = sum;
            sum = 0;
        }

        bw.write(String.valueOf(pre_sum));
        bw.flush();
        bw.close();
        br.close();
	}
}
