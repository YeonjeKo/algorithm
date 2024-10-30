import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		
		int blank = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				blank++;
			}
		}
		
		if (str.startsWith(" ")) {
			blank--;
		}
		if (str.endsWith(" ")) {
			blank--;
		}
		
		System.out.println(blank + 1);
	}

}
