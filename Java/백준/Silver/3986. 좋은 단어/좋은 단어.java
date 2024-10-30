import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            char[] alphabet = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<Character>();
            for (int j = 0; j < alphabet.length; j++) {
                if (!stack.isEmpty() && stack.peek() == alphabet[j]) {
                    stack.pop();
                } else {
                    stack.push(alphabet[j]);
                }
            }

            if (stack.isEmpty()) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
	}
}