import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M, maxCount;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];

        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                graph[r][c] = sc.nextInt();
            }
        }
        
        int pictureCount = 0;
        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                if(graph[r][c] == 1){
                    graph[r][c] = 0;
                    pictureCount++;
                    bfs(r, c);
                }
            }
        }

        System.out.println(pictureCount);
        System.out.println(maxCount);
    }
    
    static void bfs(int startY, int startX){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startY, startX});
        
        int count = 1;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int nowY = tmp[0];
            int nowX = tmp[1];
            for(int i = 0; i < 4; i++){
                int moveY = nowY + dr[i];
                int moveX = nowX + dc[i];
                
                if(0 <= moveY && moveY < N && 0 <= moveX && moveX < M && graph[moveY][moveX] == 1){
                    graph[moveY][moveX] = 0;
                    count++;
                    queue.add(new int[]{moveY, moveX});
                }
            }
        }

        if(maxCount < count) maxCount = count;
    }
}
