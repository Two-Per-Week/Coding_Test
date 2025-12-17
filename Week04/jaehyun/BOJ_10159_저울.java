import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] light;
    static List<Integer>[] heavy;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int tmp = sc.nextInt();
        light = new ArrayList[N+1];
        heavy = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            light[i] = new ArrayList<>();
            heavy[i] = new ArrayList<>();
        }

        for (int i = 0; i < tmp; i++) {
            int tmpHeavy = sc.nextInt();
            int tmpLight = sc.nextInt();
            light[tmpHeavy].add(tmpLight);
            heavy[tmpLight].add(tmpHeavy);
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(bfs(i));
        }
    }

    static int bfs(int start) {
        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int tmp : light[now]) {
                if (!visited[tmp]) {
                    queue.add(tmp);
                    visited[tmp] = true;
                }
            }
        }

        queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int tmp : heavy[now]) {
                if (!visited[tmp]) {
                    queue.add(tmp);
                    visited[tmp] = true;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) count++;
        }
        return count;
    }
}
