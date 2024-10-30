import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		String num = s.next();
		
		char[] c = new char[num.length()];
		c = num.toCharArray();
		int[] dial = new int[num.length()];
		
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 83) {
				dial[i] = 7;
			}
			else if (c[i] == 86) {
				dial[i] = 8;
			}
			else {
				int n = 2;
				for (int j = 65; j <= 90 ; j += 3, n++){
					if (j == 80 || j == 87) {
						j++;
					}
					if (c[i] <= j + 2) {
						break;
					}
				}
				dial[i] = n;
			}
		}
		
		int time = 0;
		for (int i = 0; i < dial.length; i++) {
			time += dial[i] + 1;
		}
		
		System.out.println(time);
	}

}
