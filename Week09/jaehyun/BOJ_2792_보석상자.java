import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] colors = new int[M];
        int maxColor = 0;
        for(int i = 0; i < M; i++){
            colors[i] = sc.nextInt();
            maxColor = Math.max(maxColor, colors[i]);
        }

        int left = 1;
        int right = maxColor;
        int envy = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;

            int count = 0;
            for(int i = 0; i < M; i++) {
                count += colors[i] / mid;
                if (colors[i] % mid != 0) {
                    count++;
                }
            }

            if(N >= count){
                envy = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(envy);
    }
}