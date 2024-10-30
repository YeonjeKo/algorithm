import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] U = new int[N];

        for (int i = 0; i < N; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(U);

        ArrayList<Integer> two = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                two.add(U[i] + U[j]);
            }
        }

        Collections.sort(two);
        
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (Collections.binarySearch(two, U[i] - U[j]) >= 0) {
                    System.out.println(U[i]);
                    return;
                }
            }
        }
	}
}