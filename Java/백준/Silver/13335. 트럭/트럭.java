import java.util.*;
import java.io.*;

public class Main
{
    static class Truck
     {
        int num;
        int weight;

        Truck(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        int[] time = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Truck> q = new LinkedList<Truck>();
        int sum = 0;
        int i = 0;
        int count = 0;
        while (i < n) {
            if (!q.isEmpty() && time[q.peek().num] >= w) {
                sum -= q.poll().weight;
            }
            if (sum + trucks[i] <= L && q.size() + 1 <= w) {
                q.offer(new Truck(i, trucks[i]));
                sum += trucks[i];
                i++;
            }
            for (int j = 0; j < i; j++) {
                time[j]++;
            }
            count++;
        }

        while (!q.isEmpty()) {
            count++;
            if (time[q.peek().num] >= w)
                q.poll();
            if (q.isEmpty()) {
                break;
            }
            for (i = q.peek().num; i < n; i++) {
                time[i]++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
	}
}