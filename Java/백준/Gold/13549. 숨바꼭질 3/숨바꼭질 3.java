import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<Integer>();
        int[] time = new int[200001];
        time[N]++;
        q.offer(N);
        while (!q.isEmpty()) {
            int point = q.poll();

            if (point * 2 >= 0 && point * 2 < 200000 && time[point * 2] <= 0) {
                time[point * 2] = time[point];
                q.offer(point * 2);
            }
            if (point - 1 >= 0 && point - 1 < 200000 && time[point - 1] <= 0) {
                time[point - 1] = time[point] + 1;
                q.offer(point - 1);
            }
            if (point + 1 >= 0 && point + 1 < 200000 && time[point + 1] <= 0) {
                time[point + 1] = time[point] + 1;
                q.offer(point + 1);
            }
        }
        
        bw.write(String.valueOf(time[K] - 1));
        bw.flush();
        bw.close();
    }
}