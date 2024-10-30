import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] cosmic = new int[M][N];
        int[][]	tmp = new int[M][N];
        int[][] cc = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cosmic[i][j] = Integer.parseInt(st.nextToken());
                tmp[i][j] = cosmic[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            Arrays.sort(tmp[i]);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                cc[i][j] = lower_idx(cosmic[i][j], tmp[i]);
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                if (Arrays.equals(cc[i], cc[j]))
                    cnt++;
            }
        }

        System.out.println(cnt);
	}

	public static int lower_idx(int target, int[] arr) {
        int start = 0;
        int end = arr.length;

        while (end > start) {
            int mid = (start + end) / 2;

            if (target <= arr[mid])
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }
}