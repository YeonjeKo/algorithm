import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());

            String str = br.readLine();
            str = str.substring(1, str.length() - 1);
            StringTokenizer tokenizer = new StringTokenizer(str, ",");
            
            Deque<Integer> d = new ArrayDeque<Integer>();
            while (tokenizer.hasMoreTokens()) {
                d.offerLast(Integer.parseInt(tokenizer.nextToken()));
            }

            boolean isR = false;
            boolean isError = false;
            for (int j = 0; j < p.length; j++) {
                if (isError)
                    break;
                switch(p[j]) {
                    case 'R':
                        isR = !isR;
                        break;
                    case 'D':
                        if (!d.isEmpty()) {
                            if (isR) {
                                d.pollLast();
                            } else {
                                d.pollFirst();
                            }
                        } else {
                            bw.write("error\n");
                            isError = true;
                        }
                        break;
                }
            }

            if (!isError) {
                bw.write("[");
                int size = d.size();
                for (int j = 0; j < size; j++) {
                    if (isR) {
                        bw.write(String.valueOf(d.pollLast()));
                    } else {
                        bw.write(String.valueOf(d.pollFirst()));
                    }

                    if (!d.isEmpty()) {
                        bw.write(",");
                    }
                }
                bw.write("]\n");
            }
        }

        bw.flush();
        bw.close();
	}
}