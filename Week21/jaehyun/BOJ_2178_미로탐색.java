import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;
    static int[][] graph;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        graph = new int[N][M];

        for(int r = 0; r < N; r++){
            String tmp = sc.next();
            for(int c = 0; c < M; c++){
                graph[r][c] = tmp.charAt(c)-'0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int startY, int startX){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX, 1}); // y, x, 지나온 칸 수
        boolean[][] visited = new boolean[N][M];
        visited[startY][startX] = true;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int nowY = tmp[0];
            int nowX = tmp[1];
            int count = tmp[2];

            if(nowY == N - 1 && nowX == M - 1){
                return count;
            }

            for(int i = 0; i < 4; i++){
                int moveY = nowY + dr[i];
                int moveX = nowX + dc[i];

                if(0 <= moveY && moveY < N && 0 <= moveX && moveX < M && graph[moveY][moveX] == 1){
                    if(!visited[moveY][moveX]){
                        visited[moveY][moveX] = true;
                        queue.add(new int[]{moveY, moveX, count + 1});
                    }
                }
            }
        }
        return -1;
    }
    
}
