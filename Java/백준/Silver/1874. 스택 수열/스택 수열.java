import java.util.Stack;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();

        StringBuilder sb = new StringBuilder();
        int j = 1;
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            if (j <= m) {
                while (j <= m) {
                    stack.push(j);
                    sb.append("+\n");
                    // bw.write("+\n");
                    j++;
                }
                stack.pop();
                sb.append("-\n");
                // bw.write("-\n");
            } else {
                if (stack.peek() == m) {
                    stack.pop();
                    sb.append("-\n");
                    // bw.write("-\n");
                } else {
                    sb = new StringBuilder("");
                    bw.write("NO\n");
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}