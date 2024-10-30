import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        long d[][] = new long[N][10];
        d[0][0] = 0;
        d[0][1] = 1;
        d[0][2] = 1;
        d[0][3] = 1;
        d[0][4] = 1;
        d[0][5] = 1;
        d[0][6] = 1;
        d[0][7] = 1;
        d[0][8] = 1;
        d[0][9] = 1;

        long sum = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0)
                    d[i][j] = d[i - 1][1] % 1000000000;
                else if (j == 9)
                    d[i][j] = d[i - 1][8] % 1000000000;
                else   
                    d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % 1000000000;

                if (i == N - 1)
                    sum += d[i][j];
            }
        }

        if (N == 1)
            bw.write(String.valueOf(9));
        else    
            bw.write(String.valueOf(sum % 1000000000));
        bw.flush();
        bw.close();
        br.close();
	}
}