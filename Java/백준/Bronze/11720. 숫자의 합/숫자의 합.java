import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		String str = s.next();
		
		char c[] = str.toCharArray();
		
		int sum = 0;
		for (int i = 0; i < c.length; i++) {
			int num = Character.digit(c[i], 10);
			sum += num;
		}
		
		System.out.println(sum);
	}
}
