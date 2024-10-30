import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<Integer>();

        int back = -1;
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            switch(command) {
                case "pop":
                    if (!q.isEmpty()) {
                        bw.write(String.valueOf(q.poll()) + "\n");
                    } else
                        bw.write(String.valueOf(-1) + "\n");
                    break;
                case "size":
                    bw.write(String.valueOf(q.size()) + "\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        bw.write(String.valueOf(1) + "\n");
                    } else 
                        bw.write(String.valueOf(0) + "\n");
                    break;
                case "front":
                    if (!q.isEmpty())  
                        bw.write(String.valueOf(q.peek()) + "\n");
                    else  
                        bw.write(String.valueOf(-1) + "\n");
                    break;
                case "back":
                    if (!q.isEmpty())
                        bw.write(String.valueOf(back) + "\n");
                    else
                        bw.write(String.valueOf(-1) + "\n");
                    break;
                default:
                    back = Integer.parseInt(command.split(" ")[1]);
                    q.offer(back);
                    break;
            }
        }

        bw.flush();
        bw.close();
	}
}