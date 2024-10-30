import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        boolean flag = false;
        while (!flag) {
            // if (r < 0 || r >= N || c < 0 || c >= M)
            //     continue;
        	if (map[r][c] != 1)
        		visited[r][c] = true;
            if ((visited[r - 1][c] == true || map[r - 1][c] == 1) && (visited[r][c + 1] == true || map[r][c + 1] == 1) && (visited[r + 1][c] == true || map[r + 1][c] == 1) && (visited[r][c - 1] == true || map[r][c - 1] == 1)) {
                switch(d) {
                    case 0:
                        if (map[r + 1][c] == 1) {
                            flag = true;
                            continue;
                        }
                        r++;
                        break;
                    case 1:
                        if (map[r][c - 1] == 1) {
                            flag = true;
                            continue;
                        }
                        c--;
                        break;
                    case 2:
                        if (map[r - 1][c] == 1) {
                            flag = true;
                            continue;
                        }
                        r--;
                        break;
                    case 3:
                        if (map[r][c + 1] == 1) {
                            flag = true;
                            continue;
                        }
                        c++;
                        break;
                }
            } else {
            	switch(d) {
	                case 0:
	                    d = 3;
	                    if (map[r][c - 1] == 0 && visited[r][c - 1] == false) {
	                        c--;
	                    }
	                    break;
	                case 1:
	                    d--;
	                    if (map[r - 1][c] == 0 && visited[r - 1][c] == false) {
	                        r--;
	                    }
	                    break;
	                case 2:
	                    d--;
	                    if (map[r][c + 1] == 0 && visited[r][c + 1] == false) {
	                        c++;
	                    }
	                    break;
	                case 3:
	                    d--;
	                    if (map[r + 1][c] == 0 && visited[r + 1][c] == false) {
	                        r++;
	                    }
	                    break;
	            }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == true)
                    count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
	}
}
