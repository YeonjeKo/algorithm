import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] solution = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx1 = -1;
		int idx2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N - 1; i++) {
			int idx = binarySearch(i + 1, N - 1, solution, -solution[i]);
			int tmp = Math.abs(solution[i] + solution[idx]);
			
			if (tmp < min) {
				idx1 = i;
				idx2 = idx;
				min = tmp;
			}
		}
		
		System.out.println(solution[idx1] + solution[idx2]);
	}

    public static int binarySearch(int start, int end, int[] arr, int target) {
		int i = start - 1;
		int N = end + 1;
		while (end >= start) {
			int mid = (start + end) / 2;
			
			if (arr[mid] == target)
				return mid;
			
			if (arr[mid] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		
		if (start >= N)
			start = N - 1;
		
		if (end <= i + 1)
			end = i + 1;
		
		if (Math.abs(arr[i] + arr[start]) < Math.abs(arr[i] + arr[end]))
			return start;
		else
			return end;
	}
}