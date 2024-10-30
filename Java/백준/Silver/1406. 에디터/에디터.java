import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] str = br.readLine().toCharArray();
        LinkedList<Character> list = new LinkedList<Character>();
        ListIterator<Character> iterator = list.listIterator();
        for (int i = 0; i < str.length; i++) {
            iterator.add(str[i]);
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            
            switch(s) {
                case "L":
                    if (iterator.hasPrevious())
                        iterator.previous();
                    break;
                case "D":
                    if (iterator.hasNext())
                        iterator.next();
                    break;
                case "B":
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                default:
                    iterator.add(s.charAt(2));
                    break;
            }
        }

        for (char c : list)
            // System.out.print(c);
            bw.append(c);
        bw.flush();
	}
}