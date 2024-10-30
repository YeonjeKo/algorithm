import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        int[][] room = new int[2][6]; 
        for (int i = 0; i < N; i++) {
            String str[] = br.readLine().split(" ");
            int S = Integer.parseInt(str[0]);
            int Y = Integer.parseInt(str[1]) - 1;
            room[S][Y]++;
        }

        int count = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if (room[i][j] % K != 0) {
                    count += room[i][j] / K + 1;
                } else {
                    count += room[i][j] / K;
                }
            }
        }

        System.out.println(count);
	}
}