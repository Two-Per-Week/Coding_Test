import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] d = new int[N][K+1];
        int w = sc.nextInt();
        int v = sc.nextInt();
        for(int i = 0; i <= K; i++){
            if(w <= i) d[0][i] = v;
        }

        for(int r = 1; r < N; r++){
            int w2 = sc.nextInt();
            int v2 = sc.nextInt();
            for(int c = 0; c <= K; c++){
                if(w2 <= c) d[r][c] = Math.max(d[r - 1][c], d[r - 1][c - w2] + v2);
                else d[r][c] = d[r - 1][c];
            }
        }

        System.out.println(d[N - 1][K]);
    }
}
