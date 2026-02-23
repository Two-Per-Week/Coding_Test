import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[][] d = new long[N+1][2];
        d[1][0] = 0; // 현재 값이 0인 이친수 개수
        d[1][1] = 1; // 현재 값이 1인 이친수 개수
        for(int i = 2; i <= N; i++){
            d[i][0] = d[i-1][0] + d[i-1][1];
            d[i][1] = d[i-1][0];
        }

        System.out.println(d[N][0] + d[N][1]);
    }
}
