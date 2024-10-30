import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int count = 99;
		
		if (n >= 100) {
			for (int i = 100; i <= n; i++) {
				if (checkAP(i)) {
					count++;
				}
			}
			System.out.println(count);
		} else {
			System.out.println(n);
		}
	}

	public static boolean checkAP(int n) {
        if (n == 1000) {
			return false;
		}
        
		int num[] = new int[3];
		
		for (int i = 0; i < num.length; i++) {
			if (n == 0) {
				break;
			}
			
			num[i] = n % 10;
			n /= 10;
		}
		
		if (num[1] - num[0] == num[2] - num[1]) {
			return true;
		} else {
			return false;
		}
	}
}
