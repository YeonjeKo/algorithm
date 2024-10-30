import java.io.*;
import java.util.*;

public class Main
{
    static int[] building;
    static int[] visited;
    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()) - 1;
        G = Integer.parseInt(st.nextToken()) - 1;
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        building = new int[F];
        visited = new int[F];

        visited[S]++;
        bfs(S);

        if (visited[G] == 0)
            bw.write("use the stairs");
        else 
            bw.write(String.valueOf(visited[G] - 1));
        bw.flush();
        bw.close();
 	}

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x);

        while (!q.isEmpty()) {
            int pos = q.poll();

            if (pos + U < F && visited[pos + U] == 0) {
                visited[pos + U] = visited[pos] + 1;
                q.offer(pos + U);
            }
            if (pos - D >= 0 && visited[pos - D] == 0) {
                visited[pos - D] = visited[pos] + 1;
                q.offer(pos - D);
            }
        }
    }
}