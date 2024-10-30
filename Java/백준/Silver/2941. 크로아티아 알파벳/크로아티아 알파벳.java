import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		String alter = s.next();
		char[] origin = alter.toCharArray();
	
		int count = 0;
		for (int i = 0; i < origin.length; i++) {
			if (i == origin.length - 1) {
				count++;
			}
			else if (origin[i] == 'c') {
				if (origin[i + 1] == '=' || origin[i + 1] == '-') {
					count++;
					i++;
				}
				else {
					count++;
				}
			}
			else if (origin[i] == 'd') {
				if (origin[i + 1] == 'z' && i == origin.length -2) {
					count += 2;
					i++;
				}
				else if (origin[i + 1] == 'z' && origin[i + 2] == '=') {
					count++;
					i += 2;
				}
				
				else if (origin[i + 1] == '-') {
					count++;
					i++;
				}
				else {
					count++;
				}
			}
			else if (origin[i] == 'l' && origin[i + 1] == 'j') {
				count++;
				i++;
			}
			else if (origin[i] == 'n' && origin[i + 1] == 'j') {
				count++;
				i++;
			}
			else if (origin[i] == 's' && origin[i + 1] == '=') {
				count++;
				i++;
			}
			else if (origin[i] == 'z' && origin[i + 1] == '=') {
				count++;
				i++;
			}
			else {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
