import java.util.*;
import java.io.*;

public class Main {

	static int N, M, result;
    static int[][] city;
    static int[] arr;
    static boolean[] isUsed;

    static class Chicken {
        int x;
        int y;

        Chicken(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Chicken> chickens = new ArrayList<Chicken>();
    static ArrayList<Chicken> tmpChickens;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        arr = new int[M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (city[i][j] == 2) {
                    chickens.add(new Chicken(i, j));
                }
            }
        }
        result = Integer.MAX_VALUE;
        isUsed = new boolean[chickens.size()];
        
        func(0);
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
	}
	
	static void func(int k) {
		if (k > 0) {
			tmpChickens = new ArrayList<Chicken>();
			for (int i = 0; i < M; i++) {
				tmpChickens.add(chickens.get(arr[i]));
			}
			result = Math.min(result, calc());
			
			if (k == M)
				return;
		}
		
		int start = 0;
		if (k != 0)
			start = arr[k - 1] + 1;
		
		for (int i = start; i < chickens.size(); i++) {
			if (!isUsed[i]) {
				arr[k] = i;
				isUsed[i] = true;
				func(k + 1);
				isUsed[i] = false;
			}
		}
	}
	
	static int calc() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int min = Integer.MAX_VALUE;
                if (city[i][j] == 1) {
                    for (int k = 0; k < M; k++) {
                        min = Math.min(min, Math.abs(i - tmpChickens.get(k).x) + Math.abs(j - tmpChickens.get(k).y));
                    }
                    sum += min;
                }
            }
        }

        return sum;
    }
}
