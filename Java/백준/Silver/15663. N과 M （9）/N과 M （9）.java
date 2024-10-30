import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
    static int[] arr1, arr2;
    static StringBuffer sb = new StringBuffer();
    static boolean[] isUsed;
    static Set<String> set;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr1 = new int[N];
        arr2 = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        isUsed = new boolean[N];
        set = new HashSet<String>();

        Arrays.sort(arr1);
        func(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
	
	static void func(int k) {
        if (k == M) {
        	String tmp = "";
            for (int i = 0; i < M; i++)  {
                tmp += arr1[arr2[i]] + " ";
            }
            if (!set.contains(tmp)) {
            	set.add(tmp);
            	for (int i = 0; i < M; i++)  {
                    sb.append(arr1[arr2[i]] + " ");
                }
            	sb.append("\n");
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                arr2[k] = i;
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false;
            }
        }

    }
}
