import java.util.Scanner;

public class Main {

	static int d[] = new int[10000];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10000; i++) {
			if (d[i] == 0) {
				d(i + 1);
			}
		}
		
		for (int i = 0; i < d.length; i++) {
			if (d[i] == 0) {
				System.out.println(i + 1);
			}
		}
	}

	public static void d(int a) {
		int digit;
		
		if (a < 10) {
			digit = 1;
		} else if (a >= 10 && a < 100) {
			digit = 2;
		} else if (a >= 100 && a < 1000) {
			digit = 3;
		} else if (a >= 1000 && a < 10000){
			digit = 4;
		} else {
			return;
		}
		
		int result = 0;
		
		switch (digit) {
			case 1:
				result += a + a;
				break;
			case 2:
				result += a + a % 10 + a / 10;
				break;
			case 3:
				result += a + a / 100 + a % 100 / 10 + a % 10;
				break;
			case 4:
				result += a + a / 1000 + a % 1000 / 100 + a % 100 / 10 + a % 10;
				break;
		}
		
		if (result <= 10000) {
			d[result - 1] = 1;
		}
		d(result);
	}
	
}
