import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int c = s.nextInt();
		
		for (int i = 0; i < c; i++) {
			int num = s.nextInt();
			int sum = 0;
			
			int[] scores = new int[num];
			
			for (int j = 0; j < scores.length; j++) {
				scores[j] = s.nextInt();
				sum += scores[j];
			}
			
			double avg = (double)sum / num;
			int count = 0;
			
			for (int j = 0; j < scores.length; j++) {
				if (scores[j] > avg) {
					count++;
				}
			}
			
			double result = (double)count / num * 100;
			
			System.out.println(String.format("%.3f", result) + "%");
		}
	}

}
