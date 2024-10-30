import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] fseat = new int[M];
        for (int i = 0; i < M; i++) {
            fseat[i] = Integer.parseInt(br.readLine());
        }

        int[] d = new int[N];
        d[0] = 1;

        int j = 0;
        if (fseat.length != 0 && fseat[0] == 1) {
            j++;
        }

        for (int i = 1; i < N; i++) {
            if (j < M && fseat[j] == i + 1) {
                d[i] = d[i - 1];
                j++;
            } else {
                if (i == 1)
                    d[i] = 2;
                else
                    d[i] = d[i - 2] + d[i - 1];
            }
            
            if (j > 0 && fseat[j - 1] == i) {
                d[i] = d[i - 1];
            }
        }

        bw.write(String.valueOf(d[N - 1]));
        bw.flush();
        bw.close();
        br.close();
	}
}