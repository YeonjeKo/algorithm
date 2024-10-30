import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());
        int[] A = new int[nA];
        int[] B = new int[nB];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nA; i++) {
            int tmp = Arrays.binarySearch(B, A[i]);
            if (tmp < 0) {
                cnt++;
                sb.append(A[i]).append(" ");
            }
        }

        System.out.println(cnt + "\n" + sb);
	}
}