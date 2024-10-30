import java.util.*;
import java.io.*;

public class Main {

    static int[][] laptop, sticker;
    static int N, M, R, C;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        laptop = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            sticker = new int[R][C];
            for (int j = 0; j < R; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < C; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int rot = 0;     
            Loop1:
			while (rot < 4) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < M; k++) {
						if (check(j, k)) {
							stick(j, k);
							break Loop1;
						}
					}
				}
				rot++;
				rotation();
			}
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (laptop[i][j] == 1)
                	count++;
            }
        }
        
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
	}

	static boolean check(int x, int y) {
		if (y + C > M || x + R > N || y < 0 || x < 0)
			return false;
		
        for (int i = x; i < R + x; i++) {
            for (int j = y; j < C + y; j++) {
                if (sticker[i - x][j - y] == 1 && laptop[i][j] == 1)
                	return false;
            }
        }
        return true;
    }

    static void stick(int x, int y) {
        for (int i = x; i < R + x; i++) {
            for (int j = y; j < C + y; j++) {
                if (sticker[i - x][j - y] == 1)
                	laptop[i][j] = 1;
            }
        }
    }
    
    static void rotation() {
    	int tmp = R;
    	R = C;
    	C = tmp;
    	
    	int[][] tmp2 = new int[R][C];
    	
    	for (int i = 0; i < R; i++) {
    		for (int j = 0; j < C; j++) {
    			tmp2[i][j] = sticker[C - j - 1][i];
    		}
    	}
    	sticker = tmp2.clone();
    	
    	return;
    }
}
