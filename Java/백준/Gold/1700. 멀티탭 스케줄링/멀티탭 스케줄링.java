import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] order = new int[K];
        int[] multitab = new int[N];
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= K; i++)
        	list.add(new ArrayList<>());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	order[i] = tmp;
        	list.get(tmp).add(i);
        }
        
        int cnt = 0;
        for (int i = 0; i < K; i++) {
        	int maxIdx = -1;
        	for (int j = 0; j < N; j++) {
        		if (multitab[j] == 0) {
        			multitab[j] = order[i];
        			if (!list.get(multitab[j]).isEmpty())
        				list.get(multitab[j]).remove(0);
        			maxIdx = -1;
        			break;
        		}
        		
        		if (multitab[j] == order[i]) {
        			if (!list.get(multitab[j]).isEmpty())
        				list.get(multitab[j]).remove(0);
        			maxIdx = -1;
        			break;
        		}
        		
        		if (maxIdx == -1)
        			maxIdx = j;
        		
        		int tmp1 = -1;
        		int tmp2 = -1;
        		if (list.get(multitab[maxIdx]).isEmpty())
        			tmp1 = Integer.MAX_VALUE;
        		else
        			tmp1 = list.get(multitab[maxIdx]).get(0);
        		
        		if (list.get(multitab[j]).isEmpty())
        			tmp2 = Integer.MAX_VALUE;
        		else
        			tmp2 = list.get(multitab[j]).get(0);
        		
        		if (tmp1 < tmp2)
        			maxIdx = j;
        	}
        	
        	if (maxIdx != -1) {
        		multitab[maxIdx] = order[i];
        		if (!list.get(multitab[maxIdx]).isEmpty())
        			list.get(multitab[maxIdx]).remove(0);
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
	}

}
