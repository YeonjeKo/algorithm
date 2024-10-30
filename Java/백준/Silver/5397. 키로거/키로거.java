import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            LinkedList<Character> pw = new LinkedList<Character>();
            ListIterator iter = pw.listIterator();
            for (int j = 0; j < str.length(); j++) {
                switch(str.charAt(j)) {
                    case '<':
                        if (iter.hasPrevious())
                            iter.previous();
                        break;
                    case '>':
                        if (iter.hasNext())
                            iter.next();
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(str.charAt(j));
                        break;
                }
            }

            for (char c : pw)
                bw.append(c);
            bw.newLine();
            bw.flush();    
            // bw.newLine();
        }
	}
}