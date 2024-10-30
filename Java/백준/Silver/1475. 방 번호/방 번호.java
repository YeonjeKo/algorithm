import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[9];

        while(N >= 0) {
            int n = N % 10;
            if (n == 9)
                n = 6;
            numbers[n]++;
            N /= 10;
            if (N == 0)
                break;
        }

        numbers[6] = numbers[6] / 2 + numbers[6] % 2;
        Arrays.sort(numbers);

        System.out.println(numbers[8]);
	}
}