import java.util.*;
import java.io.*;

public class Main
{
    static int[][] gear, gear2;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        gear = new int[4][8];
        gear2 = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = str.charAt(j) - '0';
                gear2[i][j] = gear[i][j];
            }
        }

        //[0, 2] [1, 6] [1, 2] [2, 6] [2, 2] [3, 6]
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int tmpD = dir;

            rot(n - 1, dir);
            switch(n) {
                case 1:
                    for (int j = 0; j < 3; j++) {
                        if (gear[j][2] != gear[j + 1][6]) {
                            if (tmpD == -1)
                                tmpD = 1;
                            else
                                tmpD = -1;
                            rot(j + 1, tmpD);
                        } else
                            break;
                    }
                    break;
                case 2:
                    if (gear[0][2] != gear[1][6]) {
                        if (dir == -1)
                            tmpD = 1;
                        else   
                            tmpD = -1;
                        rot(0, tmpD);
                    }
                    tmpD = dir;
                    for (int j = 2; j <= 3; j++) {
                        if (gear[j - 1][2] != gear[j][6]) {
                            if (tmpD == -1)
                                tmpD = 1;
                            else    
                                tmpD = -1;
                            rot(j, tmpD);
                        } else 
                            break;
                    }
                    break;
                case 3:
                    if (gear[2][2] != gear[3][6]) {
                        if (dir == -1)
                            tmpD = 1;
                        else 
                            tmpD = -1;
                        rot(3, tmpD);
                    }
                    tmpD = dir;
                    for (int j = 1; j >= 0; j--) {
                        if (gear[j + 1][6] != gear[j][2]) {
                            if (tmpD == -1)
                                tmpD = 1;
                            else    
                                tmpD = -1;
                            rot(j, tmpD);
                        } else
                            break;
                    }
                    break;
                case 4:
                    for (int j = 3; j > 0; j--) {
                        if (gear[j][6] != gear[j - 1][2]) {
                            if (tmpD == -1)
                                tmpD = 1;
                            else
                                tmpD = -1;
                            rot(j - 1, tmpD);
                        } else
                            break;
                    }
                    break;
            }

            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 8; y++) {
                    gear[x][y] = gear2[x][y];
                }
            }
        }

        int result = calc();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
	}

    static void rot(int n, int dir) {
        if (dir == 1) {
            int tmp = gear2[n][7];
            for (int i = 7; i >= 1; i--) {
                gear2[n][i] = gear2[n][i - 1];
            }
            gear2[n][0] = tmp;
        } else {
            int tmp = gear2[n][0];
            for (int i = 0; i < 7; i++) {
                gear2[n][i] = gear2[n][i + 1];
            }
            gear2[n][7] = tmp;
        }

        return;
    }

    static int calc() {
        int sum = 0;

        if (gear2[0][0] == 1)
            sum += 1;
        if (gear2[1][0] == 1)
            sum += 2;
        if (gear2[2][0] == 1)
            sum += 4;
        if (gear2[3][0] == 1)
            sum += 8;

        return sum;
    }
}