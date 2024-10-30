import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] room;
    static int[][] tmpr;
	
    static class Cctv {
        int x, y, n;

        public Cctv(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        tmpr = new int[N][M];
        ArrayList<Cctv> cctvs = new ArrayList<Cctv>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] >= 1 && room[i][j] <= 5)
					cctvs.add(new Cctv(i, j, room[i][j]));                	
            }
        }
        
        int min = N * M;
        for (int i = 0; i < Math.pow(5, cctvs.size()); i++) {
        	 for (int j = 0; j < N; j++) {
        		 for (int k = 0; k < M; k++) {
        			 tmpr[j][k] = room[j][k];
        		 }
        	 }
        	
        	 int tmp = i;
        	 for (int j = 0; j < cctvs.size(); j++) {
        		 int dir = tmp % 4;
        		 tmp /= 4;
        		 Cctv cctv = cctvs.get(j);
        		 switch(cctv.n) {
					case 1:
						if (dir == 0)
							up(cctv.x, cctv.y);
						else if (dir == 1)
							down(cctv.x, cctv.y);
						else if (dir == 2)
							left(cctv.x, cctv.y);
						else
							right(cctv.x, cctv.y);
						break;
					case 2:
						if (dir == 0 || dir == 2) {
							up(cctv.x, cctv.y);
							down(cctv.x, cctv.y);
						} else {
							left(cctv.x, cctv.y);
							right(cctv.x, cctv.y);
						}
						break;
					case 3:
						if (dir == 0) {
							right(cctv.x, cctv.y);
							down(cctv.x, cctv.y);
						} else if (dir == 1) {
							up(cctv.x, cctv.y);
							left(cctv.x, cctv.y);
						} else if (dir == 2) {
							up(cctv.x, cctv.y);
							right(cctv.x, cctv.y);
						} else {
							left(cctv.x, cctv.y);
							down(cctv.x, cctv.y);
						}
						break;
					case 4:
						if (dir == 0) {
							right(cctv.x, cctv.y);
							down(cctv.x, cctv.y);
							left(cctv.x, cctv.y);
						} else if (dir == 1) {
							up(cctv.x, cctv.y);
							down(cctv.x, cctv.y);
							left(cctv.x, cctv.y);
						} else if (dir == 2) {
							up(cctv.x, cctv.y);
							right(cctv.x, cctv.y);
							left(cctv.x, cctv.y);
						} else {
							up(cctv.x, cctv.y);
							right(cctv.x, cctv.y);
							down(cctv.x, cctv.y);
						}
						break;
					case 5:
						up(cctv.x, cctv.y);
						down(cctv.x, cctv.y);
						left(cctv.x, cctv.y);
						right(cctv.x, cctv.y);
						break;
        		 }
        	 }
        	 
        	 int count = 0;
             for (int j = 0; j < N; j++) {
             	for (int k = 0; k < M; k++) {
             		if (tmpr[j][k] == 0)
             			count++;
             	}
             }

             min = Math.min(min, count);
        }
        
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
	}

	static void up(int x, int y) {
        for (int i = x; i >= 0; i--) {
            if (tmpr[i][y] == 6)
                break;
            if (tmpr[i][y] == 0)
                tmpr[i][y] = -1;
        }
    }

    static void down(int x, int y) {
        for (int i = x; i < N; i++) {
            if (tmpr[i][y] == 6)
                break;
            if (tmpr[i][y] == 0)
                tmpr[i][y] = -1;
        }    
    }

    static void left(int x, int y) {
        for (int i = y; i >= 0; i--) {
            if (tmpr[x][i] == 6)
                break;
            if (tmpr[x][i] == 0)
                tmpr[x][i] = -1;
        }
    }

    static void right(int x, int y) {
        for (int i = y; i < M; i++) {
            if (tmpr[x][i] == 6)
                break;
            if (tmpr[x][i] == 0)
                tmpr[x][i] = -1;
        }
    }
}
