import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        while (!str.equals(".")) {
            char[] c = str.toCharArray();
            Stack<Character> paren = new Stack<Character>();
            boolean check = true;
            for (int i = 0; i < c.length; i++) {
                if (!check)
                    break;
                switch(c[i]) {
                    case '[':
                        paren.push(c[i]);
                        break;
                    case ']':
                        if (!paren.isEmpty() && paren.peek() == '[') {
                            paren.pop();
                        } else {
                            check = false;
                        }
                        break;
                    case '(':
                        paren.push(c[i]);
                        break;
                    case ')':
                        if (!paren.isEmpty() && paren.peek() == '(')
                            paren.pop();
                        else {  
                            check = false;
                        }
                        break;
                }
            }
            if (check && paren.isEmpty()) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }

            str = br.readLine();
        }

        bw.flush();
        bw.close();
	}
}