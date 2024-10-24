import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] student = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            student[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(student);
        
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int two = student[i] + student[j];
                cnt += upper_bound(j + 1, N, student, -two) - lower_bound(j + 1, N, student, -two);
            }
        }
        
        System.out.println(cnt);
	}
	
	public static long upper_bound(int start, int end, int[] arr, int target) {
		while (end > start) {
			int mid = (start + end) / 2;
			
			if (arr[mid] <= target)
				start = mid + 1;
			else
				end = mid;
		}
		
		return end + 1;
	}
	
	public static long lower_bound(int start, int end, int[] arr, int target) {
		while (end > start) {
			int mid = (start + end) / 2;

			if (arr[mid] < target)
				start = mid + 1;
			else
				end = mid;
		}
		
		return end + 1;
	}
}
