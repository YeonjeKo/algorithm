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
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            String[] s1 = s[0].split("");
            String[] s2 = s[1].split("");

            Arrays.sort(s1);
            Arrays.sort(s2);

            if (Arrays.equals(s1, s2))
                System.out.println("Possible");
            else
                System.out.println("Impossible");
        }
	}
}