import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class Main {

	public static class Flower implements Comparable<Flower> {
        LocalDate start;
        LocalDate end;

		Flower(int startMonth, int startDay, int endMonth, int endDay) {
            this.start = LocalDate.of(2023, startMonth, startDay);
            this.end = LocalDate.of(2023, endMonth, endDay);
        }

		@Override
		public int compareTo(Flower o) {
			// TODO Auto-generated method stub
			if (this.start.compareTo(o.start) < 0) 
				return -1;
			else if (this.start.compareTo(o.start) == 0) {
				if (this.end.compareTo(o.end) > 0)
					return -1;
				else if (this.end.compareTo(o.end) == 0)
					return 0;
				else
					return 1;
			}
			else
				return 1;
		}
    }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Flower[] flower = new Flower[N];
        StringTokenizer st;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            flower[i] = new Flower(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(flower);
        
        LocalDate day = LocalDate.of(2023, 3, 1);
        LocalDate endD = LocalDate.of(2023, 11, 30);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
        	if (flower[i].end.compareTo(day) <= 0)
        		continue;
        	
        	if (flower[i].start.compareTo(day) <= 0) {
        		LocalDate tmp = day;
        		for (int j = i; j < N; j++) {
        			if (flower[j].start.compareTo(day) > 0)
        				break;
        			
        			if (tmp.compareTo(flower[j].end) < 0) {
        				tmp = flower[j].end;
        			}
        		}
        		day = tmp;
        		cnt++;
        	}
        	
        	if (day.compareTo(endD) > 0)
        		break;
        }
        
        if (day.compareTo(endD) <= 0) {
        	cnt = 0;
        }
		
        System.out.println(cnt);
	}

}
