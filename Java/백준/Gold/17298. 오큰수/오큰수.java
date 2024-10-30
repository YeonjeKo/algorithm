import java.io.*;
import java.util.*;

public class Main
{
    public static class NGE {
        int n;
        int idx;

        public NGE(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<NGE> nums = new Stack<NGE>();
        int[] result = new int[N];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            int x = Integer.parseInt(tokenizer.nextToken());
            while (!nums.empty() && nums.peek().n < x) {
                result[nums.pop().idx] = x;
            }
            nums.push(new NGE(x, i));
            i++;
        }       

        for (int j = 0; j < result.length; j++) {
            bw.write(String.valueOf(result[j]) + " ");
        }

        bw.flush();
        bw.close();
	}
}