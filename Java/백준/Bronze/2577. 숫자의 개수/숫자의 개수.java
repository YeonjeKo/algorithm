import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int[] num = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		
		int mul = a * b * c;
		while (mul != 0) {
			num[mul % 10]++;
			mul /= 10;
		}
		
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
		}
	}

}
