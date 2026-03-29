import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int N;
    static int[] parents;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        parents = new int[N+1];
        parents[1] = -1;

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            graph[num1].add(num2);
            graph[num2].add(num1);
        }

        bfs(1);

        for(int i = 2; i <= N; i++){
            System.out.println(parents[i]);
        }
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i = 0; i < graph[tmp].size(); i++){
                int now = graph[tmp].get(i);
                if(!visited[now]){
                    visited[now] = true;
                    parents[now] = tmp;
                    queue.add(now);
                }
            }
        }
    }
}