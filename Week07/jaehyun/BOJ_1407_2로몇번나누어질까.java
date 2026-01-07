import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long start = sc.nextLong();
        long end = sc.nextLong();
        long sum = 0;

        sum += calculate(end);
        sum -= calculate(start-1);

        System.out.println(sum);
    }

    static long calculate(long end){
        long sum = 0;
        long now = 1;
        long tmp = end;
        while(now <= end){
            if(tmp % 2 == 1) sum += now;
            tmp /= 2;
            sum += tmp * now;
            now *= 2;
        }

        return sum;
    }
}
