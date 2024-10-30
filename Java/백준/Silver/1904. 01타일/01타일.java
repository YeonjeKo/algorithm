import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        long[] d = new long[N];
        if (N == 1) {
            bw.write(String.valueOf(1));
            bw.flush();
            return;   
        }

        d[0] = 1;
        d[1] = 2;
        for (int i = 2; i < N; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 15746;
        }

        bw.write(String.valueOf(d[N - 1]));
        bw.flush();
	}
} 