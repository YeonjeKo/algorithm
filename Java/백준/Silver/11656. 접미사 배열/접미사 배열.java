import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        String[] str = new String[S.length()];
        str[0] = S;
        for (int i = 1; i < S.length(); i++) {
            str[i] = str[i - 1].substring(1);
        }

        Arrays.sort(str);

        for (int i = 0; i < S.length(); i++) {
            bw.write(str[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
	}
}