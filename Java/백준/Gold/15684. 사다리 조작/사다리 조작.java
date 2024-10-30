import java.util.*;
import java.io.*;

public class Main {

	static int N, M, H, num;
	static int[][] ladder, tmp;
	static boolean[] isUsed;
	static int[] arr;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new int[H][N - 1];
        isUsed = new boolean[H * (N - 1)];
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	ladder[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }
        
        for (int i = 0; i <= 3; i++) {
        	num = i;
        	arr = new int[num];
        	flag = false;
        	func(0);
        	if (flag) {
        		bw.write(String.valueOf(i));
        		break;
        	}
        }
        
        if (!flag)
        	bw.write(String.valueOf(-1));
        
        bw.flush();
        bw.close();
        br.close();
	}

	static void func(int k) {
		if (flag) {
			return;
		}
		
		if (k == num) {
			copy();
			for (int i = 0; i < num; i++) {
				if (arr[i] % (N - 1) - 1 >= 0 && tmp[arr[i] / (N - 1)][arr[i] % (N - 1) - 1] == 1)
					return;
				if (arr[i] % (N - 1) + 1 < N - 1 && tmp[arr[i] / (N - 1)][arr[i] % (N - 1) + 1] == 1)
					return;
				tmp[arr[i] / (N - 1)][arr[i] % (N - 1)] = 1;
			}
			
			if (check()) {
				flag = true;
			}
			
			return;
		}
		
		int start = 0;
		if (k != 0)
			start = arr[k - 1] + 1;
		
		for (int i = start; i < H * (N - 1); i++) {
			if (!isUsed[i]) {
				if (ladder[i / (N - 1)][i % (N - 1)] == 0) {
					arr[k] = i;
					isUsed[i] = true;
					func(k + 1);
					isUsed[i] = false;
				}
			}
		}
	}
	
	static boolean check() {
		int left, right, cur;
		boolean rslt = true;
		
		for (int i = 0; i < N - 1; i++) {
			cur = i;
			for (int j = 0; j < H; j++) {
				left = cur - 1;
				right = cur;
				
				if (left >= 0 && tmp[j][left] == 1) {
					cur--;
					continue;
				}
				if (right < N - 1 && tmp[j][right] == 1) {
					cur++;
					continue;
				}
			}
			if (cur != i) {
				rslt = false;
				break;
			}
		}
		
		return rslt;
	}
	
	static void copy() {
		tmp = new int[H][N - 1];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N - 1; j++) {
				tmp[i][j] = ladder[i][j];
			}
		}
	}
}
