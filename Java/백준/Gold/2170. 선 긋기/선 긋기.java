import java.util.*;
import java.io.*;

public class Main {

	public static class Line implements Comparable<Line>{
        int x;
        int y;

        Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

		@Override
		public int compareTo(Line o) {
			// TODO Auto-generated method stub
			if (this.x < o.x)
				return -1;
			else if (this.x == o.x) {
				if (this.y < o.y)
					return 1;
				else if (this.y == o.y)
					return 0;
				else
					return -1;
			} else 
				return 1;
		}
    }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Line> line = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            line.add(new Line(x, y));
        }
        
        Collections.sort(line);
        
        int start = line.get(0).x;
        int end = line.get(0).y;
        int sum = end - start;
        for (int i = 1; i < N; i++) {
        	if (line.get(i).x == start)
        		continue;
        		
        	if (line.get(i).x > end) {
        		end = line.get(i).y;
        		start = line.get(i).x;
        		sum += end - start;
        	} else {
        		if (line.get(i).y > end ) {
        			sum += line.get(i).y - end;
        			end = line.get(i).y;
        		} else {
        			continue;
        		}
        	}
        }
        
        System.out.println(sum);
	}

}
