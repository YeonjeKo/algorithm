import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] nums = new int[n];
        int k = 0;
        while(st.hasMoreTokens()) {
            nums[k] = Integer.parseInt(st.nextToken());
            k++;
        }
        
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(nums);
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            int check = Arrays.binarySearch(nums, x - nums[i]);
            if (check < 0 || check == i)
                continue;
            count++;
        }

        System.out.println(count / 2);
	}
}