import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
        ArrayList<String> arr = new ArrayList<>();
        
        while (st.hasMoreTokens()) {
            String tmp = st.nextToken();
            arr.add(tmp);
        }

        int sum = 0;
        int sub = 0;
        boolean flag = false;
        for (int i = 0; i < arr.size(); i++) {
            switch (arr.get(i)) {
                case "-":
                    if (flag) {
                        sum -= sub;
                        sub = 0;
                    }
                    else
                        flag = true;
                    break;
                case "+":
                    break;
                default:
                    if (flag) {
                        sub += Integer.parseInt(arr.get(i));
                    } else {
                        sum += Integer.parseInt(arr.get(i));
                    }
            }
        }
        sum -= sub;

        System.out.println(sum);
	}
}