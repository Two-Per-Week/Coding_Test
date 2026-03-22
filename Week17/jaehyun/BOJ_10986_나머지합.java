import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] prefixSumRemain = new int[N + 1];
        long[] remainCounts = new long[M];

        for(int i = 1; i <= N; i++){
            prefixSumRemain[i] = (prefixSumRemain[i - 1] + sc.nextInt()) % M;
            remainCounts[prefixSumRemain[i]]++;
        }

        long sum = 0;
        remainCounts[0]++; // 처음부터 선택하는 거 고려
        for(int i = 0; i < M; i++){
            long tmp = remainCounts[i];
            sum += tmp * (tmp - 1) / 2;
        }

        System.out.println(sum);
    }
}