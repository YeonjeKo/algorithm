import java.util.*;
import java.io.*;

public class Main
{
    static int[][][] tetromino = {
        {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
        {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
        {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
        {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
        {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
        {{1, 0}, {1, 1}, {1, 2}, {0, 2}},
        {{1, 0}, {1, 1}, {1, 2}, {0, 0}},
        {{0, 1}, {1, 1}, {2, 1}, {0, 0}},
        {{0, 1}, {1, 1}, {2, 1}, {2, 0}},
        {{0, 0}, {1, 0}, {2, 0}, {0, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
        {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
        {{1, 0}, {1, 1}, {0, 1}, {0, 2}},
        {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
        {{0, 1}, {1, 1}, {1, 0}, {2, 0}},
        {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
        {{1, 0}, {1, 1}, {1, 2}, {0, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
        {{0, 1}, {1, 1}, {2, 1}, {1, 0}}
    };

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 19; i++) {
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < M; b++) {
                    int sum = 0;
                    for (int j = 0; j < 4; j++) {
                        int x = tetromino[i][j][0] + a;
                        int y = tetromino[i][j][1] + b;
                        
                        if (x < 0 || x >= N || y < 0 || y >= M)
                            break;

                        sum += paper[x][y];
                        if (sum > max)
                            max = sum;
                    } 
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
	}
}