import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = prime(N);

        int j = 0;
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (i == 0)
                sum = arr.get(i);
            else
                sum -= arr.get(i - 1);
            while (j < arr.size()) {
                if (sum >= N) {
                    if (sum == N)
                        cnt++;
                    break;                
                }
                j++;
                if (j != arr.size())
                	sum += arr.get(j);
            }
        }

        System.out.print(cnt);
	}

    public static ArrayList<Integer> prime(int n) {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                arr.add(i);
        }

        return arr;
    }
}