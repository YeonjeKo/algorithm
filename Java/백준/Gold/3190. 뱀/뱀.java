import java.util.*;
import java.io.*;

public class Main
{
    static class Pos {
        int x, y;

        Pos (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        StringTokenizer st;

        //사과 있는 칸 = 1
        //뱀 있는 칸 = 2
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        char[] snake_info = new char[10000];

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            snake_info[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
        }

        int time = 0;
        Deque<Pos> snake = new LinkedList<>();
        snake.offerLast(new Pos(0, 0));
        board[0][0] = 2;

        //오른쪽부터 시계방향으로 0 ~ 3
        int dir = 0;
        while (true) {
            time++;

            Pos cur = snake.peekLast();
            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                break;
            if (board[nx][ny] == 2)
                break;

            snake.offerLast(new Pos(nx, ny));
            if (board[nx][ny] == 1) {
                board[nx][ny] = 2;
            } else if (board[nx][ny] == 0) {
                Pos tmp = snake.pollFirst();
                board[tmp.x][tmp.y] = 0;
                board[nx][ny] = 2;
            }

            if (snake_info[time] == 'D') {
                if (dir == 3) {
                    dir = 0;
                } else {
                    dir++;
                }
            } else if (snake_info[time] == 'L') {
                if (dir == 0) {
                    dir = 3;
                } else {
                    dir--;
                }
            }
        }

        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
        br.close();
	}
}