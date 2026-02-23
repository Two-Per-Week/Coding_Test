import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        graph = new LinkedList<>();
        for(int i = 0; i <= N; i++) graph.add(new LinkedList<>());

        for(int i = 0; i < M; i++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }

        visited = new boolean[N+1];
        visited[V] = true;
        System.out.print(V);
        dfs(V);

        System.out.println();

        visited = new boolean[N+1];
        visited[V] = true;
        System.out.print(V);
        bfs(V);
    }

    static void dfs(int start){
        List<Integer> list = graph.get(start);
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            if(!visited[list.get(i)]){
                visited[list.get(i)] = true;
                System.out.print(" " + list.get(i));
                dfs(list.get(i));
            }
        }

    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int now = queue.poll();
            List<Integer> list = graph.get(now);
            Collections.sort(list);

            for(int i = 0; i < list.size(); i++){
                if(!visited[list.get(i)]){
                    visited[list.get(i)] = true;
                    queue.add(list.get(i));
                    System.out.print(" " + list.get(i));
                }
            }
        }
    }

}
