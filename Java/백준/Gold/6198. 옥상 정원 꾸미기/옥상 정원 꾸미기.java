import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> buildings = new Stack<Integer>();
        
        long count = 0;
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            while (!buildings.empty() && buildings.peek() <= h) {
                buildings.pop();
            }
            count += buildings.size();
            buildings.push(h);
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
	}
}