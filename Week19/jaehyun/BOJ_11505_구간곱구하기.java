import java.util.*;

public class Main {
    static int size;
    static long[] segmentTree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        size = (int) Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)));
        segmentTree = new long[size * 2];
        for(int i = 0; i < N; i++){
            segmentTree[size + i] = sc.nextLong();
        }

        for(int i = size + N; i < size * 2; i++){
            segmentTree[i] = 1;
        }

        for(int i = size - 1; i > 0; i--){
            segmentTree[i] = (segmentTree[i * 2] % 1_000_000_007) * (segmentTree[i * 2 + 1] % 1_000_000_007) % 1_000_000_007;
        }

        for(int i = 0; i < M + K; i++){
            int tmp = sc.nextInt();
            if(tmp == 1){
                update(sc.nextInt() - 1, sc.nextLong());
            } else {
                System.out.println(multiply(sc.nextLong(), sc.nextLong(), 1, size, 1));
            }
        }
    }

    static long multiply(long L, long R, long nowL, long nowR, int nowNode){
        if(R < nowL || nowR < L) return 1;
        if(L <= nowL && nowR <= R) return segmentTree[nowNode];
        long mid = (nowL + nowR) / 2;
        return (multiply(L, R, nowL, mid, nowNode * 2) % 1_000_000_007) * (multiply(L, R, mid + 1, nowR, nowNode * 2 + 1) % 1_000_000_007) % 1_000_000_007;
    }

    static void update(int idx, long value){
        idx += size;
        segmentTree[idx] = value;
        while(idx > 1){
            idx /= 2;
            segmentTree[idx] = (segmentTree[idx * 2] % 1_000_000_007) * (segmentTree[idx * 2 + 1] % 1_000_000_007) % 1_000_000_007;
        }
    }
}