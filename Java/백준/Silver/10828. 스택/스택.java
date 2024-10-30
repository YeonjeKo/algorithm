import java.util.Stack;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            switch(command) {
                case "pop":
                    if (!stack.empty())
                        bw.write(String.valueOf(stack.pop()) + "\n");
                    else   
                        bw.write(String.valueOf(-1) + "\n");
                    break;
                case "size":
                    bw.write(String.valueOf(stack.size()) + "\n");
                    break;
                case "empty":
                    if (stack.empty())
                        bw.write(String.valueOf(1) + "\n");
                    else 
                        bw.write(String.valueOf(0) + "\n");
                    break;
                case "top":
                    if (!stack.empty())
                        bw.write(String.valueOf(stack.peek()) + "\n");
                    else   
                        bw.write(String.valueOf(-1) + "\n");
                    break;
                default:
                    int X = Integer.parseInt(command.split(" ")[1]);
                    stack.push(X);
            }
        }

        bw.flush();
	}
}