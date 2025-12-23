import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int minCount = Integer.MAX_VALUE;
        int count = 1;
        int sum = nums[0];
        int left = 0;
        int right = 0;
        while (true) {
            if (sum >= S) {
                if (minCount > count) minCount = count;
                sum -= nums[left++];
                count--;
            } else {
                if (right == N-1) break;
                sum += nums[++right];
                count++;
            }

            if (left > right) {
                minCount = 1;
                break;
            }
        }

        if(minCount == Integer.MAX_VALUE) minCount = 0;
        System.out.println(minCount);
    }
}
