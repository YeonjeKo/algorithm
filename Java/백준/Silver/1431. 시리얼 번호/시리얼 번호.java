import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<String> serialn = new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            serialn.add(br.readLine());
        }

        serialn.sort((String s1, String s2) -> {
            if (s1.length() != s2.length())
                return s1.length() - s2.length();
            else {
                int n1 = sum_place_value(s1);
                int n2 = sum_place_value(s2);

                if (n1 != n2)
                    return n1 - n2;
                else
                    return s1.compareTo(s2);
            }   
        });

        for (int i = 0; i < N; i++) {
            bw.write(serialn.get(i) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
	}

    static int sum_place_value(String s) {
        char[] charArr = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (Character.isDigit(charArr[i]))
                sum += charArr[i]  - '0';
        }

        return sum;
    }
}