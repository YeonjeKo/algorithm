import java.io.*;
import java.util.*;

public class Main
{
    static class Dot {
        int x, y;

        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Dot> dots = new ArrayList<Dot>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Dot d = new Dot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            dots.add(d);
        }

        Collections.sort(dots, (Dot d1, Dot d2) -> {
            if (d1.y != d2.y)
                return d1.y - d2.y;
            else
                return d1.x - d2.x;
        });

        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(dots.get(i).x) + " " + String.valueOf(dots.get(i).y) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
	}
}