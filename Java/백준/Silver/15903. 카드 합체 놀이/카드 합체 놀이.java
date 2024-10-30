import java.util.*;
import java.io.*;

public class Main
{
        public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] card = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(card);

        for (int i = 0; i < m; i++) {
            if (n > 2 && card[0] > card[2]) {
                Arrays.sort(card);
            }

            long tmp = card[0] + card[1];
            card[0] = tmp;
            card[1] = tmp;
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += card[i];
        }

        System.out.println(sum);
	}
}