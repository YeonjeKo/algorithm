import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(pow(A, B, C)));
        bw.flush();
        bw.close();
	}

    static long pow(int a, int b, int c) {
        if (b == 1)
            return a % c;
        
        long result = pow(a, b / 2, c);
        result = result * result % c;

        if (b % 2 != 0)
            return result * a % c;
        else 
            return result;
    }
}