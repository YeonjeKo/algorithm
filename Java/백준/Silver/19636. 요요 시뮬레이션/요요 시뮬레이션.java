import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int W0 = s.nextInt();
		int I0 = s.nextInt();
		int T = s.nextInt();
		int D = s.nextInt();
		int I = s.nextInt();
		int A = s.nextInt();
		
		int W =  W0 + D * (I - (I0 + A));

		if (W <= 0) {
			System.out.println("Danger Diet");
		}
		else {
			System.out.println(W + " " + I0);
		}
		
		int bmr = I0;
		for (int i = 0; i < D; i++) {
			W0 += (I - (bmr + A));
			if (Math.abs(I - (bmr + A)) > T) {
				double tmp = (double)(I - (bmr + A)) / 2;
				bmr += Math.floor(tmp);
			}
			
			if (W0 <= 0 || bmr <= 0) {
				System.out.println("Danger Diet");
				return;
			}
		}
		
		System.out.print(W0 + " " + bmr);
		
		if (I0 - bmr > 0) {
			System.out.println(" YOYO");
		}
		else {
			System.out.println(" NO");
		}
	}

}
