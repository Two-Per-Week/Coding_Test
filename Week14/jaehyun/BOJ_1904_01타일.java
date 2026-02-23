import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] d = new int[N+1];
        d[0] = 0;
        d[1] = 1;
        if(2 <= N){
            d[2] = 2;
        }
        for(int i = 3; i <= N; i++){
            d[i] = (d[i-1] + d[i-2]) % 15746;
        }

        System.out.println(d[N]);
    }
}
