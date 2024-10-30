import java.util.*;
import java.io.*;

public class Main
{   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(z(N, r, c)));
        bw.flush();
        bw.close();
	}

    static int z(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int half = (int)Math.pow(2, n - 1);
        if (r < half && c < half)
            return z(n - 1, r, c);
        else if (r < half && c >= half)
            return half * half + z(n - 1, r, c - half);
        else if (r >= half && c < half)
            return 2 * half * half + z(n - 1, r - half, c);
        else
            return 3 * half * half + z(n - 1, r- half, c- half);
    }
}