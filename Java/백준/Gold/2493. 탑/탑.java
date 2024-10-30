import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int i = 1;
        while (tokenizer.hasMoreTokens()) {
            int x = Integer.parseInt(tokenizer.nextToken());
            stack1.push(x);
            map.put(x, i);
            i++;
        }

        int[] top = new int[N];
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
            while (!stack2.empty()) {
                if (!stack1.empty() && stack2.peek() < stack1.peek()) {
                    top[map.get(stack2.pop()) - 1] = map.get(stack1.peek());
                } else {
                    break;
                }
            }
        }

        for (int j = 0; j < top.length; j++) {
            bw.write(String.valueOf(top[j] + " "));
        }

        bw.flush();
        bw.close();     
    } 
}