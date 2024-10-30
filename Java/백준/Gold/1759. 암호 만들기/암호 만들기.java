import java.util.*;
import java.io.*;

public class Main {
	
	static int L, C;
    static char[] str;
    static int[] password;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        str = new char[C];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
        	str[i] = st.nextToken().charAt(0);
        }
        isUsed = new boolean[C];
        password = new int[L];

        Arrays.sort(str);
        func(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}

	static void func(int k) {
        if (k == L) {
            int countV = 0;
            int countC = 0;
            String s = "";
            for (int i = 0; i < L; i++) {
                s += str[password[i]];
                if (str[password[i]] == 'a' || str[password[i]] == 'e' || str[password[i]] == 'i' || str[password[i]] == 'o' || str[password[i]] == 'u')
                    countV++;
                else
                	countC++;
            }

            if (countV >= 1 && countC >= 2) {
                sb.append(s + "\n");
            }
            return;
        }

        int start = 0;
        if (k != 0)
            start = password[k - 1] + 1;

        for (int i = start; i < C; i++) {
            if (!isUsed[i]) {
                password[k] = i;
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false;
            }
        }
    }
}
