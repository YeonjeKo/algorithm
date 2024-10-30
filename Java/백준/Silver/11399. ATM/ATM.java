import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(line);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum += line[i];
            }
        }

        System.out.println(sum);
	}
}