import java.util.*;

public class Main {
    // 서 북 동 남
    static int[] dr = {0, -1, 0, 1}; 
    static int[] dc = {-1, 0, 1, 0};
    static int R, C;
    static int[][][] graph;
    static List<Integer> size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        R = sc.nextInt();
        size = new LinkedList<>();
         // 기본 숫자(방향), 카운트
        graph = new int[R][C][2];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                graph[r][c][0] = sc.nextInt();
            }
        }

        int roomNum = 0;
        for(int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (graph[r][c][1] == 0) {
                    roomNum++;
                    roomNumBfs(r, c, roomNum);
                }
            }
        }

        int maxSize = 0;
        for (int s : size) {
            if (s > maxSize) {
                maxSize = s;
            }
        }
        
        // 전체 순회하면서 옆에꺼 상하좌우 비교 및 다른 방이면 값 비교
        int maxSumSize = 0;
        for(int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                for (int i = 0; i < 4; i++) {
                    int moveY = r + dr[i];
                    int moveX = c + dc[i];

                    if(0 > moveY || moveY >= R || 0 > moveX || moveX >= C) continue;

                    if (graph[moveY][moveX][1] != graph[r][c][1]) { // 다른 방일 때
                        int sum = size.get(graph[moveY][moveX][1] - 1) + size.get(graph[r][c][1] - 1);
                        if( sum > maxSumSize) {
                            maxSumSize = sum;
                        }
                    }
                }
            }
        }
        System.out.println(roomNum);
        System.out.println(maxSize);
        System.out.println(maxSumSize);
    }

    static void roomNumBfs(int r, int c, int roomNum) {
        Queue<int[]> queue = new LinkedList<>();
        graph[r][c][1] = roomNum;
        // y, x
        queue.add(new int[]{r, c});
        size.add(roomNum - 1, 1);
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int tmp = graph[now[0]][now[1]][0];
            for (int i = 0; i < 4; i++) {
                if ((tmp & 1 << i) == 0){
                    int moveY = now[0] + dr[i];
                    int moveX = now[1] + dc[i];

                    if(0 > moveY || moveY >= R || 0 > moveX || moveX >= C) continue;

                    if(graph[moveY][moveX][1] == 0) {
                        graph[moveY][moveX][1] = roomNum;
                        queue.add(new int[]{moveY, moveX});
                        size.set(roomNum - 1, size.get(roomNum - 1) + 1);
                    }
                }
            }
        }
    }
}