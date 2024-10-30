import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            q.offer(i + 1);
        }

        int i = 1;
        while(q.size() != 1) {
            if (i % 2 != 0) {
                q.poll();
            } else {
                q.offer(q.poll());
            }
            i++;
        }

        bw.write(String.valueOf(q.poll()));
        bw.flush();
        bw.close();
	}
}