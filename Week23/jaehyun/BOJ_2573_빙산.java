import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;
    static int[][] graph;
    static int[][] minus;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        
        graph = new int[N][M];
        minus = new int[N][M];
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                graph[r][c] = sc.nextInt();
            }
        }
        
        int year = 0;
        boolean notDivide = false;
        
        loop: while (true) {
            int count = 0;
            visited = new boolean[N][M];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (!visited[r][c] && graph[r][c] != 0) {
                        count++;
                        if (count >= 2) break loop;
                        bfs(r, c);
                    }
                }
            }
            if (count == 0) {
                notDivide = true;
                break;
            }
            year++;
        }
        
        if(notDivide) System.out.println(0);
        else System.out.println(year);
    }
    
    static void bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startY][startX] = true;
        queue.add(new int[] {startY, startX});
        
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int nowY = tmp[0];
            int nowX = tmp[1];

            for(int i = 0; i < 4; i++){
                int moveY = nowY + dr[i];
                int moveX = nowX + dc[i];
                
                if(0 <= moveY && moveY < N && 0 <= moveX && moveX < M){
                    if(graph[moveY][moveX] == 0){
                        minus[nowY][nowX]--;
                    } else if(!visited[moveY][moveX]){
                        visited[moveY][moveX] = true;
                        queue.add(new int[]{moveY, moveX});
                    }
                }
            }
        }

        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                if(minus[r][c] != 0){
                    graph[r][c] += minus[r][c];
                    if(graph[r][c] < 0) graph[r][c] = 0;
                    minus[r][c] = 0;
                }
            }
        }
    }
}
