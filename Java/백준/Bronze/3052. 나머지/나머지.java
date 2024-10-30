import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int[] remainder = new int[42];
		int[] num = new int[10];
		
		for (int i = 0; i < num.length; i++) {
			num[i] = s.nextInt();
			
			remainder[num[i] % 42]++;
		}
		
		int count = 0;
		for (int i = 0; i < remainder.length; i++) {
			if (remainder[i] != 0) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
