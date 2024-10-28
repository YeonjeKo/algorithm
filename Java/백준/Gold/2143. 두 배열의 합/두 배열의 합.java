import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dA = new int[(n * (n + 1)) / 2];
		int[] dB = new int[(m * (m + 1)) / 2];
		
		int idx = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += A[j];
				dA[idx] = sum;
				idx++;
			}
		}
		
		idx = 0;
		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = i; j < m; j++) {
				sum += B[j];
				dB[idx] = sum;
				idx++;
			}
		}
		
		Arrays.sort(dA);
		Arrays.sort(dB);
		
		long cnt = 0;
		for (int i = 0; i < dA.length; i++) {
			int upper = upper_bound(dB, T - dA[i], 0, dB.length);
			int lower = lower_bound(dB, T - dA[i], 0, dB.length);
			
			cnt += upper - lower;
		}
		
		System.out.println(cnt);
	}

	public static int upper_bound (int[] arr, int target, int start, int end) {
		while (end > start) {
			int mid = (start + end) / 2;
			
			if (arr[mid] <= target)
				start = mid + 1;
			else
				end = mid;
		}
		
		return end;
	}
	
	public static int lower_bound (int[] arr, int target, int start, int end) {
		while (end > start) {
			int mid = (start + end) / 2;
		
			if (arr[mid] < target)
				start = mid + 1;
			else
				end = mid;
		}
		
		return end;
	}
}
