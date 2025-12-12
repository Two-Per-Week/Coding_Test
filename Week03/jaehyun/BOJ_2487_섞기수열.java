import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] order;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        order = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            order[i] = sc.nextInt();
        }

        long answer = 1;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int cycle = loop(i);
                answer = (answer * cycle) / uclid(answer, cycle);
            }
        }

        System.out.println(answer);
    }

    static int loop (int num) {
        int count = 1;
        int next = order[num];
        while (true) {
            if (next == num) {
                return count;
            } else {
                visited[next] = true;
                next = order[next];
                count++;
            }
        }
    }

    static long uclid (long num1, long num2) {
        long tmp = num2;
        if (num1 < num2) {
            num2 = num1;
            num1 = tmp;
        }

        while (num2 != 0) {
            tmp = num2;
            num2 = num1 % num2;
            num1 = tmp;
        }
        return num1;
    }
}