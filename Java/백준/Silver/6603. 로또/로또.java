import java.io.*;
import java.util.*;

public class Main
{
    static int K;
    static int[] S, lotto;
    static StringBuffer sb = new StringBuffer();
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String tmp = st.nextToken();
        while (!tmp.equals("0")) {
            sb.setLength(0);
            //StringBuilder 비우기
            K = Integer.parseInt(tmp);
            S = new int[K];
            for (int i = 0; i < K; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            isUsed = new boolean[K];
            lotto = new int[6];
            func(0);

            bw.write(sb.toString());
            bw.write("\n");

            st = new StringTokenizer(br.readLine());
            tmp = st.nextToken();
        }

        bw.flush();
        bw.close();
        br.close();
	}

    static void func(int k) {
        if (k == 6) {
            for (int i = 0; i < 6; i++) { 
                sb.append(S[lotto[i]] + " ");
            }
            sb.append("\n");
            return;
        }

        int start = 0;
        if (k != 0)
            start = lotto[k - 1];

        for (int i = start; i < K; i++) {
            if (!isUsed[i]) {
                lotto[k] = i;
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false;
            }
        }

    }
}