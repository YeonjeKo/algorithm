import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		String str = s.next();
		
		for (int i = 97; i < 123; i++) {
			int index = str.indexOf((char)i);
			System.out.print(index + " ");
		}
	}

}
