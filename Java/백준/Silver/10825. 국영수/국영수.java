import java.io.*;
import java.util.*;

public class Main
{
    static class Student {
        String name;
        int korean, english, math;

        Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Student> students = new ArrayList<Student>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            students.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(students, (Student s1, Student s2) -> {
            if (s1.korean != s2.korean) {
                return s2.korean - s1.korean;
            } else {
                if (s1.english != s2.english) {
                    return s1.english - s2.english;
                } else {
                    if (s1.math != s2.math) {
                        return s2.math - s1.math;
                    } else {
                        return s1.name.compareTo(s2.name);
                    }
                }
            }
        });

        for (int i = 0; i < students.size(); i++) {
            bw.write(students.get(i).name + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
	}
}