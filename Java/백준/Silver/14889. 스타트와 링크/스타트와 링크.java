import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static boolean[] isUsed;
    static int[] start, link;
    static int min = Integer.MAX_VALUE;
    static int[][] stat;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        stat = new int[N][N];
        isUsed = new boolean[N];
        start = new int[N / 2];
        link = new int[N / 2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
	}

    static void func(int k) {
        if (k == N / 2) {
            int i = 0, j = 0, l = 0;
            while (i < N) {
                if (j < N / 2 && start[j] == i)
                    j++;
                else {
                    link[l] = i;
                    l++;
                }
                i++;
            } 

            int rslt = calc();
            if (min > rslt)
                min = rslt;

            return;
        }

        int sta = 0;
        if (k != 0)
            sta = start[k - 1] + 1;
        
        for (int i = sta; i < N; i++) {
            if (!isUsed[i]) {
                start[k] = i;
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false;
            }
        }
    }

    static int calc() {
        int s_sum = 0;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                if (j == i)
                    continue;
                s_sum += stat[start[i]][start[j]];
            }
        }

        int l_sum = 0;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                if (j == i)
                    continue;
                l_sum += stat[link[i]][link[j]];
            }
        }

        int rslt;
        if (s_sum > l_sum)
            rslt = s_sum - l_sum;
        else    
            rslt = l_sum - s_sum;

        return rslt;
    }
}