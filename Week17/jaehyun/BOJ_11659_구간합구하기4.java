import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] sum = new int[N + 1];
        for(int i = 0; i < N; i++){
            sum[i + 1] = sum[i] + sc.nextInt();
        }

        for(int i = 0; i < K; i++){
            System.out.println(- sum[sc.nextInt() - 1] + sum[sc.nextInt()]);
        }
    }
}