import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int N = Integer.parseInt(str.split(" ")[0]);
        int K = Integer.parseInt(str.split(" ")[1]);

        Queue<Integer> q = new LinkedList<Integer>();
        int[] time = new int[200001];
        time[N]++;
        q.offer(N);
        while (!q.isEmpty()) {
            int point = q.poll();

            if (point - 1 >= 0 && point - 1 < 200000 && time[point - 1] <= 0) {
                time[point - 1] = time[point] + 1;
                q.offer(point - 1);
            }
            if (point + 1 >= 0 && point + 1 < 200000 && time[point + 1] <= 0) {
                time[point + 1] = time[point] + 1;
                q.offer(point + 1);
            }
            if (point * 2 >= 0 && point * 2 < 200000 && time[point * 2] <= 0) {
                time[point * 2] = time[point] + 1;
                q.offer(point * 2);
            }
        }
        
        bw.write(String.valueOf(time[K] - 1));
        bw.flush();
        bw.close();
    }
}