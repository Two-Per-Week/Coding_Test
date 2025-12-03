import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] min = new int[N];
        int[] max = new int[N];
        int[] diff = new int[N];
        for (int i = 0; i < N; i++) {
            min[i] = sc.nextInt();
            max[i] = sc.nextInt();
            diff[i] = sc.nextInt();
        }

        long left = 1;
        long right = Integer.MAX_VALUE;
        long result = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < N; i++) {
                if (mid < min[i]) continue;

                int end = (int) Math.min(mid, max[i]);
                count += ((end - min[i]) / diff[i]) + 1;
            }

            if (count % 2 == 1) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (result == -1) System.out.println("NOTHING");
        else {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (min[i] <= result && result <= max[i] && ((int)result - min[i]) % diff[i] == 0) {
                    count++;
                }
            }
            System.out.println(result + " " + count);
        }
    }
}