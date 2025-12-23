import java.util.*;

public class Main {
    static int N;
    static int[] targetColors;
    static List<Integer>[] graph, realGraph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        targetColors = new int[N+1];
        for (int i = 1; i <= N; i++) {
            targetColors[i] = sc.nextInt();
        }

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N-1; i++) {
            int tmp = sc.nextInt();
            int tmp2 = sc.nextInt();
            graph[tmp].add(tmp2);
            graph[tmp2].add(tmp);
        }

        realGraph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            realGraph[i] = new ArrayList<>();
        }
        makeRealGraph();

        System.out.println(painting());
    }

    static void makeRealGraph() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i : graph[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    realGraph[now].add(i);
                    queue.add(i);
                }
            }
        }
    }

    static int painting() {
        int result = 0;
        Queue<int[]> queue = new LinkedList<>(); // 현재 숫자, 부모의 색
        queue.add(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int num = now[0];
            int color = now[1];
            if (targetColors[num] != color) {
                color = targetColors[num];
                result++;
            }

            for (int i : realGraph[num]) {
                queue.add(new int[]{i, color});
            }
        }

        return result;
    }
}
