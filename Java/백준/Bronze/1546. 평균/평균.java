import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		double[] score = new double[n];
		
		double max = -1;
		for (int i = 0; i < score.length; i++) {
			score[i] = s.nextInt();
			max = Math.max(max, score[i]);
		}
		
		double sum = 0;
		for (int i = 0; i < score.length; i++) {
			score[i] = score[i] / max * 100;
			sum += score[i];
		}
		
		double average = sum / score.length;
		
		System.out.println(average);
	}

}
