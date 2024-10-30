import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (!words.contains(str))
                words.add(str);
        }

        words.sort((String s1, String s2) -> {
            if (s1.length() != s2.length())
                return s1.length() - s2.length();
            else
                return s1.compareTo(s2);
        });

        for (int i = 0; i < words.size(); i++) {
            bw.write(words.get(i) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
	}
}