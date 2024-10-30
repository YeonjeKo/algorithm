import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int tmp;

        if (W % (M + 1) != 0)
            tmp = W / (M + 1) + 1;
        else
            tmp = W / (M + 1);

        if (H % (N + 1) != 0)
            tmp *= H / (N + 1) + 1;
        else
            tmp *= H / (N + 1);

        bw.write(String.valueOf(tmp));
        bw.flush();
    }
}