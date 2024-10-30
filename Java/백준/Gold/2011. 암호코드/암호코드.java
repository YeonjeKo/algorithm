import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String N = br.readLine();
        char[] password = N.toCharArray();

        int[] d = new int[N.length()];

        if (password[0] - '0' == 0) {
            System.out.println(0);
            return;
        }

        if (N.length() == 1) {
        	System.out.println(1);
        	return;
        }
        
        d[0] = 1;     
        if (password[1] - '0' == 0) {
            if ((password[0] - '0') * 10 + (password[1] - '0') > 26) {
                System.out.println(0);
                return;
            } else {
            	d[1] = 1;
            }
        } else {
            if ((password[0] - '0') * 10 + (password[1] - '0') <= 26)
                d[1] = 2;
            else
                d[1] = 1;
        }

        for (int i = 2; i < N.length(); i++) {
            if (password[i] - '0' == 0) {
                if ((password[i - 1] - '0') * 10 + (password[i] - '0') > 26 || (password[i - 1] - '0') * 10 + (password[i] - '0') == 0) {
                    System.out.println(0);
                    return;
                } else {
                    d[i] = d[i - 2];
                }
            } else {
            	if (password[i - 1] - '0' == 0) {
            		d[i] = d[i - 1];
            	} else {
            		if ((password[i - 1] - '0') * 10 + (password[i] - '0') <= 26)
                        d[i] = (d[i - 2] + d[i - 1]) % 1000000;
                    else
                        d[i] = d[i - 1];
            	}
            }   
	    }

        System.out.println(d[N.length() - 1]);
	}

}
