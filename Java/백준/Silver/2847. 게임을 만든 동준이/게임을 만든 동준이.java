import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = 1; i < N; i++) {
            if (score[i - 1] <= score[i]) {
                cnt += score[i] - score[i - 1] + 1;
                score[i] = score[i - 1] - 1;
            }     
        }

        System.out.println(cnt);
	}
}