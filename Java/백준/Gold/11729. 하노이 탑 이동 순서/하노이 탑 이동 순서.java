import java.util.*;
import java.io.*;

public class Main
{
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        hanoi(1, 3, N);

        bw.write(String.valueOf(count + "\n"));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}

    static void hanoi(int a, int b, int n) {
        if (n == 1) {
            count++;
            sb.append(a + " " + b + "\n");
            return;
        }
        count++;
        hanoi(a, 6 - a - b, n - 1);
        sb.append(a + " " + b + "\n");
        hanoi(6 - a - b, b, n - 1);     
    }
}