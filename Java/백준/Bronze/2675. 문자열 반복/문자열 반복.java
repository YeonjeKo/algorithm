import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		for (int i = 0; i < t; i++) {
			int r = s.nextInt();
			String str = s.next();
	
			char c[] = str.toCharArray();
			for (int j = 0; j < c.length; j++) {
				for (int k = 0; k < r; k++) {
					System.out.print(c[j]);
				}
			}
			System.out.println();
		}
	}

}
