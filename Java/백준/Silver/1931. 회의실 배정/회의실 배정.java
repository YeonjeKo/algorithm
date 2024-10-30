import java.util.*;
import java.io.*;

public class Main {

	static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

		@Override
		public int compareTo(Meeting o) {
			// TODO Auto-generated method stub
            if (this.end - o.end == 0)
				return this.start - o.start;
			return this.end - o.end;
		}
    }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayList<Meeting> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            arr.add(new Meeting(start, end));
        }
        
        Collections.sort(arr);
        
        int tmp = arr.get(0).end;
        int cnt = 1;
        for (int i = 1; i < N; i++) {
        	if (arr.get(i).start >= tmp) {
        		tmp = arr.get(i).end;
        		cnt++;
        	} else {
        		continue;
        	}
        }
        
        System.out.println(cnt);
	}

}
