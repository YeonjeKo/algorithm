import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            d[i] = i;

            for (int j = 1; j * j <= i; j++) {
            	d[i] = Math.min(d[i], 1 + d[i - j * j]);
            }
        }
        
        System.out.println(d[N]);
	}
}
