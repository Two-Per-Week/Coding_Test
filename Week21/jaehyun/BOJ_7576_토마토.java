import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;
    static int[][] graph;
    static Queue<int[]> queue;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        graph = new int[N][M];
        queue = new LinkedList<>();

        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                graph[r][c] = sc.nextInt();
                if(graph[r][c] == 1){
                    queue.add(new int[]{r, c, 0}); // y, x, 날짜
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs(){
        int maxCount = 0;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int nowY = tmp[0];
            int nowX = tmp[1];
            int count = tmp[2];

            if(maxCount < count) maxCount = count;

            for(int i = 0; i < 4; i++){
                int moveY = nowY + dr[i];
                int moveX = nowX + dc[i];

                if(0 <= moveY && moveY < N && 0 <= moveX && moveX < M && graph[moveY][moveX] == 0){
                    graph[moveY][moveX] = 1;
                    queue.add(new int[]{moveY, moveX, count + 1});
                }
            }
        }

        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                if(graph[r][c] == 0){
                    return -1;
                }
            }
        }

        return maxCount;
    }
    
}
