import java.io.*;
import java.util.*;

public class Main {
	static class Cnt {
        long num;
        int count;

        Cnt(long num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        //StringTokenizer st;
        long[] card = new long[N];
        for (int i = 0; i < N; i++) {
            //st = new StringTokenizer(br.readLine());
            card[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(card);

        List<Cnt> cnts = new ArrayList<Cnt>();
        int tmp = 0;
        for (int i = 1; i < N; i++) {
            if (card[i] != card[i - 1]) {
                cnts.add(new Cnt(card[i - 1], i - tmp));
                tmp = i;
            }
        }
        cnts.add(new Cnt(card[N - 1], N - tmp));

        Collections.sort(cnts, (Cnt c1, Cnt c2) -> {
            if (c1.count != c2.count)
                return c2.count - c1.count;
            else
                return c1.num > c2.num ? 1:-1;
        });

        bw.write(String.valueOf(cnts.get(0).num));
        bw.flush();
        bw.close();
        br.close();
	}
}
