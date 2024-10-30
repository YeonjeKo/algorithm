import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split("");
        Stack<String> paren = new Stack<String>();
        int tmp = 0;
        for (int i = 0; i < str.length; i++) {
            tmp = 0;
            switch(str[i]) {
                case "(":
                    paren.push(str[i]);
                    break;
                case ")":
                    if (paren.isEmpty() || paren.peek().equals("[")) {
                        bw.write(String.valueOf(0));
                        bw.flush();
                        bw.close();
                        return;
                    }
                    if (paren.peek().equals("(")) {
                        paren.pop();
                        paren.push("2");
                    } else {
                        while (!paren.isEmpty() && isInteger(paren.peek())) {
                            tmp += Integer.parseInt(paren.pop());
                        }
                        if (!paren.isEmpty() && paren.peek().equals("(")) {
                            paren.pop();
                            paren.push(Integer.toString(tmp * 2));
                        } else {
                            bw.write(String.valueOf(0));
                            bw.flush();
                            bw.close();
                            return;
                        }
                    }
                    break;
                case "[":
                    paren.push(str[i]);
                    break;
                case "]":
                    if (paren.isEmpty() || paren.peek().equals("(")) {
                        bw.write(String.valueOf(0));
                        bw.flush();
                        bw.close();
                        return;
                    }
                    if (paren.peek().equals("[")) {
                        paren.pop();
                        paren.push("3");
                    } else {
                        while (!paren.isEmpty() && isInteger(paren.peek())) {
                            tmp += Integer.parseInt(paren.pop());
                        }
                        if (!paren.isEmpty() && paren.peek().equals("[")) {
                            paren.pop();
                            paren.push(Integer.toString(tmp * 3));
                        } else {
                            bw.write(String.valueOf(0));
                            bw.flush();
                            bw.close();
                            return;
                        }
                    }
                    break;
            }
        }

        int result = 0;
        while (!paren.isEmpty()) {
            if (isInteger(paren.peek()))
                result += Integer.parseInt(paren.pop());
            else {
                paren.pop();
                result = 0;
                break;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
	}

    public static boolean isInteger(String s) {
        if (s.equals("(") || s.equals("[")) {
            return false;
        }
        return true;
    }
}