import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int count = 0;       
        for (int i = 0; i < N; i++) {
        	boolean flag = false;
        	boolean[] slope = new boolean[N];
        	for (int j = 0; j < N - 1; j++) {
        		int tmp = map[i][j] - map[i][j + 1];
        		if (tmp == 0) {
        			continue;
        		} else if (tmp == 1) {
        			int low = map[i][j + 1];
        			for (int k = 0; k < L; k++) {
        				if (j + 1 + k >= N || map[i][j + 1 + k] != low || slope[j + 1 + k]) {
        					flag = true;
        					break;
        				}
        				slope[j + 1 + k] = true;
        			}
        		} else if (tmp == -1) {
        			int low = map[i][j];
        			for (int k = 0; k < L; k++) {
        				if (j - k < 0 || map[i][j - k] != low || slope[j - k]) {
        					flag = true;
        					break;
        				}
        				slope[j - k] = true;
        			}
        		} else {
        			flag = true;
        		}
        	}
        	if (!flag)
        		count++;
        }
        
        for (int i = 0; i < N; i++) {
        	boolean flag = false;
        	boolean[] slope = new boolean[N];
        	for (int j = 0; j < N - 1; j++) {
        		int tmp = map[j][i] - map[j + 1][i];
        		if (tmp == 0) {
        			continue;
        		} else if (tmp == 1) {
        			int low = map[j + 1][i];
        			for (int k = 0; k < L; k++) {
        				if (j + 1 + k >= N || map[j + 1 + k][i] != low || slope[j + 1 + k]) {
        					flag = true;
        					break;
        				}
        				slope[j + 1 + k] = true;
        			}
        		} else if (tmp == -1) {
        			int low = map[j][i];
        			for (int k = 0; k < L; k++) {
        				if (j - k < 0 || map[j - k][i] != low || slope[j - k]) {
        					flag = true;
        					break;
        				}
        				slope[j - k] = true;
        			}
        		} else {
        			flag = true;
        		}
        	}
        	if (!flag)
        		count++;
        }
        
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
	}

}
