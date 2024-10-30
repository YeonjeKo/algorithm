import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] coin = new Integer[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coin, Collections.reverseOrder());

        int cnt = 0;
        while (K > 0) {
            for (int i = 0; i < N; i++) {
                if (coin[i] > K)
                    continue;
                else {
                    cnt += K / coin[i];
                    K = K % coin[i];
                    break;
                }
            }
        }

        System.out.println(cnt);
	}

}
