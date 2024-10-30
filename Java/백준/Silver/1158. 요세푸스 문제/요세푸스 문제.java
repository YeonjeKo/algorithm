import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        LinkedList<Integer> circle = new LinkedList<Integer>();
        ListIterator iter = circle.listIterator();
        for (int i = 0; i < N; i++) {
            iter.add(i + 1);
        }

        bw.write("<");
        // System.out.print("<");
        iter = circle.listIterator();
        int count = 1;
        while (iter.hasNext() || iter.hasPrevious()) {
            if (!iter.hasNext()) {
                iter = circle.listIterator();
            }
            iter.next();
            if (count % K == 0) {
                int tmp = (Integer)iter.previous();
                bw.write(String.valueOf(tmp));
                // System.out.print(tmp);
                iter.remove();
                if (!iter.hasNext() && !iter.hasPrevious()) {
                    count++;
                    continue;
                }
                bw.write(", ");
                // System.out.print(", ");
            }
            count++;
        }

        bw.write(">");
        bw.flush();
        // System.out.println(">");
	}
}