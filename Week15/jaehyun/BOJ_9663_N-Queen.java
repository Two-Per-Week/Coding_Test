import java.util.*;

public class Main {
    static int N;
    static int[] board;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        board = new int[N];
        Arrays.fill(board, -1);

        for(int i = 0; i < N; i++){
            board[0] = i;
            dfs(1);
            board[0] = 0;
        }

        System.out.println(count);
    }

    static void dfs(int now){
        if(now == N){
            count++;
            return;
        }

        loop: for(int i = 0; i < N; i++){
            for(int j = 0; j < now; j++){
                if(board[j] == i) continue loop;
                int diff = now - j;
                if(board[j] - diff == i || board[j] + diff == i) continue loop;
            }
            board[now] = i;
            dfs(now + 1);
            board[now] = -1;
        }
    }
}
