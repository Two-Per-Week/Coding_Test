import java.util.*;

public class Main {
    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        char[][] graph = new char[N][N];
        char[][] colorBlindnessGraph = new char[N][N];
        for(int r = 0; r < N; r++){
            String S = sc.next();
            for(int c = 0; c < N; c++){
                graph[r][c] = S.charAt(c);
                if(graph[r][c] == 'R'){
                    colorBlindnessGraph[r][c] = 'G';
                } else {
                    colorBlindnessGraph[r][c] =  graph[r][c];
                }
            }
        }

        int count = 0;
        visited = new boolean[N][N];
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(!visited[r][c]){
                    visited[r][c] = true;
                    count++;
                    dfs(r, c, graph);
                }
            }
        }
        System.out.print(count);

        count = 0;
        visited = new boolean[N][N];
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(!visited[r][c]) {
                    visited[r][c] = true;
                    count++;
                    dfs(r, c, colorBlindnessGraph);
                }
            }
        }
        System.out.print(" " + count);

    }

    static void dfs(int nowY, int nowX, char[][] graph){
        for(int i = 0; i < 4; i++){
            int moveY = nowY + dr[i];
            int moveX = nowX + dc[i];

            if(0 <= moveY && moveY < N && 0 <= moveX && moveX < N){
                if(!visited[moveY][moveX] && graph[moveY][moveX] == graph[nowY][nowX]){
                    visited[moveY][moveX] = true;
                    dfs(moveY, moveX, graph);
                }
            }
        }
    }

}
