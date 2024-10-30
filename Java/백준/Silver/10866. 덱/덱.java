import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> d = new ArrayDeque<Integer>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            switch (command) {
                case "pop_front":
                    if (!d.isEmpty()) {
                        bw.write(String.valueOf(d.pollFirst()) + "\n");
                    } else {
                        bw.write(String.valueOf(-1) + "\n");
                    }
                    break;
                case "pop_back":
                    if (!d.isEmpty())
                        bw.write(String.valueOf(d.pollLast()) + "\n");
                    else
                        bw.write(String.valueOf(-1) + "\n");
                    break;
                case "size":
                    bw.write(String.valueOf(d.size()) + "\n");
                    break;
                case "empty":
                    if (d.isEmpty())
                        bw.write(String.valueOf(1) + "\n");
                    else
                        bw.write(String.valueOf(0) + "\n");
                    break;
                case "front":
                    if (!d.isEmpty())
                        bw.write(String.valueOf(d.peekFirst()) + "\n");
                    else   
                        bw.write(String.valueOf(-1) + "\n");
                    break;
                case "back":
                    if (!d.isEmpty())
                        bw.write(String.valueOf(d.peekLast()) + "\n");
                    else   
                        bw.write(String.valueOf(-1) + "\n");
                    break;
                default:
                    int x = Integer.parseInt(command.split(" ")[1]);
                    command = command.split(" ")[0];

                    if (command.equals("push_front")) {
                        d.offerFirst(x);
                    } else {
                        d.offerLast(x);
                    }
                    break;
            }
        }

        bw.flush();
        bw.close();
	}
}