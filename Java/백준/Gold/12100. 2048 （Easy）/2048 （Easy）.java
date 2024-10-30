import java.util.*;
import java.io.*;

public class Main
{
    static int[][] board, board2;
    static int N;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        board2 = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < 1024; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    board2[j][k] = board[j][k];
                }
            }

            int tmp = i;
            for (int j = 0; j < 5; j++) {
                int dir = tmp % 4;
                tmp /= 4;
                tilt(dir);
            }

            int tmpM = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    tmpM = Math.max(tmpM, board2[j][k]);
                }
            }
            max = Math.max(max, tmpM);
        }
        
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
	}

    static void tilt(int dir) {
        switch (dir) {
            case 0:
                for (int j = 0; j < N; j++) {
                    int tmp = 0;
                    while (tmp < N - 1) {
                        if (board2[tmp][j] == 0) {
                            int tmp2 = tmp;
                            while (tmp2 < N - 2 && board2[tmp2 + 1][j] == 0)
                                tmp2++;
                            board2[tmp][j] = board2[tmp2 + 1][j];
                            board2[tmp2 + 1][j] = 0; 
                        }
                        tmp++;
                    }
                    tmp = 0;
                    while (tmp < N - 1 && board2[tmp][j] != 0) {
                        if (board2[tmp][j] == board2[tmp + 1][j]) {
                            board2[tmp][j] *= 2;
                            int tmp2 = tmp;
                            while (tmp2 + 2 <= N - 1 && board2[tmp2 + 2][j] != 0) {
                                board2[tmp2 + 1][j] = board2[tmp2 + 2][j];
                                tmp2++;
                            }
                            board2[tmp2 + 1][j] = 0;
                        }
                        tmp++;
                    }
                }
                break;
            case 1:
                for (int i = 0; i < N; i++) {
                    int tmp = N - 1;
                    while (tmp > 0) {
                        if (board2[i][tmp] == 0) {
                            int tmp2 = tmp;
                            while (tmp2 > 1 && board2[i][tmp2 - 1] == 0)
                                tmp2--;
                            board2[i][tmp] = board2[i][tmp2 - 1];
                            board2[i][tmp2 - 1] = 0; 
                        }
                        tmp--;
                    }
                    tmp = N - 1;
                    while (tmp > 0 && board2[i][tmp] != 0) {
                        if (board2[i][tmp] == board2[i][tmp - 1]) {
                            board2[i][tmp] *= 2;
                            int tmp2 = tmp;
                            while (tmp2 - 2 >= 0 && board2[i][tmp2 - 2] != 0) {
                                board2[i][tmp2 - 1] = board2[i][tmp2 - 2];
                                tmp2--;
                            }
                            board2[i][tmp2 - 1] = 0;
                        }
                        tmp--;
                    }
                }
                break;
            case 2:
                for (int j = 0; j < N; j++) {
                    int tmp = N - 1;
                    while (tmp > 0) {
                        if (board2[tmp][j] == 0) {
                            int tmp2 = tmp;
                            while (tmp2 > 1 && board2[tmp2 - 1][j] == 0)
                                tmp2--;
                            board2[tmp][j] = board2[tmp2 - 1][j];
                            board2[tmp2 - 1][j] = 0; 
                        }
                        tmp--;
                    }
                    tmp = N - 1;
                    while (tmp > 0 && board2[tmp][j] != 0) {
                        if (board2[tmp][j] == board2[tmp - 1][j]) {
                            board2[tmp][j] *= 2;
                            int tmp2 = tmp;
                            while (tmp2 - 2 >= 0 && board2[tmp2 - 2][j] != 0) {
                                board2[tmp2 - 1][j] = board2[tmp2 - 2][j];
                                tmp2--;
                            }
                            board2[tmp2 - 1][j] = 0;
                        }
                        tmp--;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < N; i++) {
                    int tmp = 0;
                    while (tmp < N - 1) {
                        if (board2[i][tmp] == 0) {
                            int tmp2 = tmp;
                            while (tmp2 < N - 2 && board2[i][tmp2 + 1] == 0)
                                tmp2++;
                            board2[i][tmp] = board2[i][tmp2 + 1];
                            board2[i][tmp2 + 1] = 0; 
                        }
                        tmp++;
                    }
                    tmp = 0;
                    while (tmp < N - 1 && board2[i][tmp] != 0) {
                        if (board2[i][tmp] == board2[i][tmp + 1]) {
                            board2[i][tmp] *= 2;
                            int tmp2 = tmp;
                            while (tmp2 + 2 <= N - 1 && board2[i][tmp2 + 2] != 0) {
                                board2[i][tmp2 + 1] = board2[i][tmp2 + 2];
                                tmp2++;
                            }
                            board2[i][tmp2 + 1] = 0;
                        }
                        tmp++;
                    }
                }
                break;
        }

        return;
    } 
}