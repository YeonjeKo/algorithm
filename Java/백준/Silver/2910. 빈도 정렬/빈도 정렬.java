import java.io.*;
import java.util.*;

public class Main {
	static class Value {
		int count, idx;
		
		Value(int count, int idx) {
			this.count = count;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        HashMap<Integer, Value> msg = new HashMap<Integer, Value>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (!msg.containsKey(tmp))
                msg.put(tmp, new Value(1, i));
            else {
            	int idx = msg.get(tmp).idx;
                int count = msg.get(tmp).count + 1;
                msg.replace(tmp, new Value(count, idx));
            }
        }

        List<Value> valueList = new ArrayList<Value>(msg.values());
        Collections.sort(valueList, (Value v1, Value v2) -> {
        	if (v1.count != v2.count)
        		return v2.count - v1.count;
        	else
        		return v1.idx - v2.idx;
        });

        for (int i = 0; i < valueList.size(); i++) {
	        for (Integer key : msg.keySet()) {
	        	if (msg.get(key) == valueList.get(i))
	        		for (int j = 0; j < valueList.get(i).count; j++) {
	        			bw.write(String.valueOf(key + " "));
	        		}
	        }
        }
        bw.flush();
        bw.close();
        br.close();
	}
}
