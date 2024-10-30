import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		for (int i = 0; i < n; i++) {
			int score = 0, accum = 0;
			
			String quiz = s.next();
			char[] result = quiz.toCharArray();
			
			for (int j = 0; j < result.length; j++) {
				if (result[j] == 'O') {
					if (j != 0 && result[j - 1] == 'O') {
						accum++;
					}
					else {
						accum = 0;
					}
					score += 1 + accum;
				}
			}
			
			System.out.println(score);
		}
	}

}
