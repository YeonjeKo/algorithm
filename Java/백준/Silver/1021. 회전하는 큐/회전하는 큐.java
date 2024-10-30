import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        
        Deque<Integer> d = new ArrayDeque<Integer>();
        int[] idx = new int[N];
        for (int i = 0; i < N; i++) {
            idx[i] = i;
            d.offerLast(i);
        }

        int count = 0;
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        while (tokenizer.hasMoreTokens()) {
            int x = Integer.parseInt(tokenizer.nextToken()) - 1;

            if (idx[x] - idx[d.peekFirst()] <= idx[d.peekLast()] - idx[x] + 1) {
                while (d.peekFirst() != x) {
                    idx[d.peekFirst()] = idx[d.peekLast()] + 1;
                    d.offerLast(d.pollFirst());
                    count++;
                }
                d.pollFirst();
            } else {
                while (d.peekFirst() != x) {
                    idx[d.peekLast()] = idx[d.peekFirst()] - 1;
                    d.offerFirst(d.pollLast());
                    count++;
                }
                d.pollFirst();
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
	}
}