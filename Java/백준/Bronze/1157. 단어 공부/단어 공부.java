import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		String str = s.next();
		str = str.toUpperCase();
		
		int alpha[] = new int[26];
		for (int i = 0; i < str.length(); i++) {
			alpha[(int)str.charAt(i) - 65]++;
		}
		
		int max = 0;
		boolean equal = false;
		for (int i = 1; i < alpha.length; i++) {
			if (alpha[max] < alpha[i]) {
				max = i;
				equal = false;
			} else if (alpha[max] == alpha[i]) {
				equal = true;
			}
		}
		
		if (equal) {
			System.out.println("?");
		} else {
			System.out.println((char)(max + 65));
		}
		
	}

}
