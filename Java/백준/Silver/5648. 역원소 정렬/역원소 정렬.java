import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        List<Long> num = new ArrayList<Long>();

        String str = br.readLine();
        StringTokenizer st;
        StringBuffer sb;

        while (str != null) {
            st = new StringTokenizer(str);
            while (st.hasMoreTokens()) {
                sb = new StringBuffer(st.nextToken());
                num.add(Long.parseLong(sb.reverse().toString()));
            }
            str = br.readLine();
        }

        num.remove(0);
        Collections.sort(num);

        for (int i = 0; i < num.size(); i++) {
            bw.write(String.valueOf(num.get(i) + "\n"));
        }
        bw.flush();
        bw.close();
        br.close();
	}
}