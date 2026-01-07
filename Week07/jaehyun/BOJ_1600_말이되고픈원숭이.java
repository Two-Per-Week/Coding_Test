import java.util.*;

public class Main {
    // 상 하 좌 우, 나이트 8방
    static int[] dr = {-1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2};
    static int R, C;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jumpCount = sc.nextInt();
        C = sc.nextInt();
        R = sc.nextInt();

        graph = new int[R][C];
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                graph[r][c] = sc.nextInt();
            }
        }

        System.out.println(bfs(jumpCount));
    }

    static long bfs(int maxJumpCount){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[R][C][maxJumpCount+1];
        queue.add(new int[]{0, 0, 0, 0}); // y, x, turn, jumpCount
        visited[0][0][0] = true;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int nowY = tmp[0];
            int nowX = tmp[1];
            int turn = tmp[2];
            int jumpCount = tmp[3];

            if(nowY == R - 1 && nowX == C - 1) return turn;

            for(int i = 0; i < 12; i++){
                int moveY = nowY + dr[i];
                int moveX = nowX + dc[i];

                if(0 > moveX || moveX >= C || 0 > moveY || moveY >= R) continue;

                if(graph[moveY][moveX] == 1 || i >= 4 && jumpCount + 1 > maxJumpCount) continue;

                if(i >= 4 && !visited[moveY][moveX][jumpCount+1]){
                    visited[moveY][moveX][jumpCount+1] = true;
                    queue.add(new int[]{moveY, moveX, turn + 1, jumpCount + 1});
                } else if(i < 4 && !visited[moveY][moveX][jumpCount]){
                    visited[moveY][moveX][jumpCount] = true;
                    queue.add(new int[]{moveY, moveX, turn + 1, jumpCount});
                }
            }

        }

        return -1;
    }
}
