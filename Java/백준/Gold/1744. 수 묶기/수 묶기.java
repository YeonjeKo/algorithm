import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //Integer[] arr = new Integer[N];
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            //arr[i] = Integer.parseInt(br.readLine());
        	arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr, Collections.reverseOrder());

        int sum = 0;
        int mul = 0;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if (arr.get(0) > 0) {
                if (arr.get(0) == 1) {
                	sum += 1;
                	arr.remove(0);
                	continue;
                }
                
                if (mul == 0)
                    mul += arr.get(0);
                else {
                    mul *= arr.get(0);
                    sum += mul;
                    mul = 0;
                }
                arr.remove(0);
            } else {
            	if (!flag) {
            		flag = true;
            		Collections.sort(arr);
            		sum += mul;
            		mul = 0;
            	}
            	
            	if (arr.get(0) == 0) {
            		if (mul != 0) {
            			sum += mul;
            			mul = 0;
            		}
                    continue;
            	}
            	
                if (mul == 0) {
                	if (arr.size() > 1 && arr.get(1) == 0)
                		continue;
                    mul += arr.get(0);
                }
                else {
                    mul *= arr.get(0);
                    sum += mul;
                    mul = 0;
                }
                arr.remove(0);
          	}
        }

        if (mul != 0) 
            sum += mul;

        System.out.println(sum);
	}

}
