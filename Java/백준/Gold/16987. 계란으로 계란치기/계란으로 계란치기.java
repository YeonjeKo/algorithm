import java.util.*;
import java.io.*;

public class Main {

	static class Egg {
        int durability, weight;

        public Egg(int d, int w) {
            durability = d;
            weight = w;
        }

    }

    static int N;
    static int max = 0;
    static int count = 0;
    static Egg[] eggs;
    static int[] isBroken;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];
        isBroken = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Egg e = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            eggs[i] = e;
            isBroken[i] = eggs[i].durability;
        }

        func(0);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
	}

	static void func(int k) {
		if (k == N) {
			max = Math.max(max, count);
			return;
		}

		if (isBroken[k] <= 0 || count == N - 1) {
			func(k + 1);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (i != k && isBroken[i] > 0) {
				isBroken[i] -= eggs[k].weight;
				isBroken[k] -= eggs[i].weight;
				if (isBroken[k] <= 0)
					count++;
				if (isBroken[i] <= 0)
					count++;
				func(k + 1);
				if (isBroken[k] <= 0)
					count--;
				if (isBroken[i] <= 0)
					count--;
				isBroken[i] += eggs[k].weight;
				isBroken[k] += eggs[i].weight;
			}
		}
	}
}
