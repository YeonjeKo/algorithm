import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		String str1 = s.next();
		String str2 = s.next();
		
		int num1 = Integer.parseInt(new StringBuilder(str1).reverse().toString());
		int num2 = Integer.parseInt(new StringBuilder(str2).reverse().toString());
		
		if (num1 < num2) {
			System.out.println(num2);
		} else {
			System.out.println(num1);
		}
	}

}
