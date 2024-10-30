import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] nums = new int[N];
        int k = 0;
        while(st.hasMoreTokens()) {
            nums[k] = Integer.parseInt(st.nextToken());
            k++;
        }
        
        int v = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (nums[i] == v)
                count++;
        }

        System.out.println(count);
	}
}