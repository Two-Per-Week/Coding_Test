import java.util.*;

public class Main {
    static int N;
    static int[][] W, memo;
    static final int INF = 17000000;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        W = new int[N][N];
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                W[r][c] = sc.nextInt();
            }
        }

        memo = new int[1 << N][N];
        for(int i = 0; i < (1 << N); i++){
            Arrays.fill(memo[i], -1);
        }

        System.out.println(TSP(0, 1 << 0));
    }

    static int TSP(int now, int visited){
        if(visited == (1 << N) - 1){
            return (W[now][0] == 0) ? INF : W[now][0];
        }

        if(memo[visited][now] != -1) {
            return memo[visited][now];
        }

        memo[visited][now] = INF;

        for(int i = 0; i < N; i++){
            int tmp = (1 << i) & visited;
            if(tmp == 0 && W[now][i] != 0){
                int res = W[now][i] + TSP(i, visited | (1 << i));
                memo[visited][now] = Math.min(memo[visited][now], res);
            }
        }

        return memo[visited][now];
    }
}