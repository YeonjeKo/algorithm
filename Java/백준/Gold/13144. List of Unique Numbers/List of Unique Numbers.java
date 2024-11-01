import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] check = new int[100001];
        int j = 0;
        long cnt = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0)
                check[arr[i]]++;
            else {
                check[arr[i - 1]]--;
                cnt += j - i;
            }
           
            while (j < N) {
                if (check[arr[j]] > 1) {
                    break;
                }
                cnt++;
                j++;
                if (j != N)
                    check[arr[j]]++;
            }
        }

        System.out.println(cnt);
	}

}
