import java.util.*;
import java.io.*;

public class Main {

	static class Member {
        int age;
        String name;

        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
        int N = Integer.parseInt(br.readLine());
        List<Member> mem = new ArrayList<Member>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            mem.add(new Member(age, name));
        }
        
//        Collections.sort(mem, new Comparator<Member>() {
//
//			@Override
//			public int compare(Member o1, Member o2) {
//				// TODO Auto-generated method stub
//				return o1.age - o2.age;
//			}
//        	
//        });
        //람다식
        Collections.sort(mem, (Member m1, Member m2) -> m1.age - m2.age);
        
        for (int i = 0; i < N; i++) {
        	bw.write(String.valueOf(mem.get(i).age) + " " + mem.get(i).name + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
	}

}
