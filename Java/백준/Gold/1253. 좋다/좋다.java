import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        boolean[] visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(num);
        
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int two = num[i] + num[j];
                int upper = upper_bound(0, N, num, two);
                int lower = lower_bound(0, N, num, two);

                if (lower < N) {
                    for (int k = lower; k < upper; k++) {
                        if (!visited[k] && k != i && k != j) {
                            visited[k] = true;
                            cnt++;
                        }   
                    }
                }
            }
        }

        System.out.println(cnt);
	}

	public static int upper_bound(int start, int end, int[] arr, int target) {
		while (end > start) {
			int mid = (start + end) / 2;
			
			if (arr[mid] <= target)
				start = mid + 1;
			else
				end = mid;
		}
		
		return end;
	}
	
	public static int lower_bound(int start, int end, int[] arr, int target) {
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
