import java.io.*;
import java.util.*;

public class Main
{
    static int N;
    static boolean isUsed[];
    static int[] arr, nums, op;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        op = new int[N - 1];
        isUsed = new boolean[N - 1];
        arr = new int[N - 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0, j = 0; i < 4; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            while (tmp > 0) {
                op[j] = i;
                tmp--;
                j++;
            }
        }

        func(0);

        bw.write(String.valueOf(max) + "\n" + String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
	}

    static void func(int k) {
        if (k == N - 1) {
            calc();
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false;
            }
        }
    }

    static void calc() {
        int rslt = nums[0];
        for (int i = 1; i < N; i++) {
            switch(op[arr[i - 1]]) {
                case 0:
                    rslt += nums[i];
                    break;
                case 1:
                    rslt -= nums[i];
                    break;
                case 2:
                    rslt *= nums[i];
                    break;
                case 3:
                    rslt /= nums[i];
                    break;
            }
        }

        if (min > rslt)
            min = rslt;
        if (max < rslt)
            max = rslt;
    }
}