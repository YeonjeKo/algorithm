import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            bw.write(String.valueOf(0) + "\n" + String.valueOf(0));
            bw.flush();
            return;
        }
        
        int[] d = new int[Math.abs(n) + 1];
        d[0] = 0;
        d[1] = 1;
        for (int i = 2; i <= Math.abs(n); i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 1000000000;
        }

        if (n > 0) 
            bw.write(String.valueOf(1));
        else {
            if (Math.abs(n) % 2 == 0)
                bw.write(String.valueOf(-1));
            else 
                bw.write(String.valueOf(1));
        }
        bw.write("\n" + String.valueOf(d[Math.abs(n)]));
        bw.flush();
	}
}