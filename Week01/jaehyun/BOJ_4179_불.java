import java.util.*;

public class Main {
    static int R, C, time;
    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Node> queue;
    static char[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        Queue<Node> fire = new LinkedList<>();
        queue = new LinkedList<>();
        graph = new char[R][C];
        for (int r = 0; r < R; r++) {
            String s = sc.next();
            for (int c = 0; c < C; c++) {
                char tmp = s.charAt(c);
                graph[r][c] = tmp;
                if (tmp == 'F') {
                    fire.add(new Node(r, c, 0 , 'F'));
                } else if(tmp == 'J') {
                    queue.add(new Node(r, c, 0, 'J'));
                }
            }
        }

        // 지훈이가 불보다 먼저 움직이는 메커니즘
        while (!fire.isEmpty()) {
            queue.add(fire.poll());
        }

        time = Integer.MAX_VALUE;
        bfs();

        if (time == Integer.MAX_VALUE) System.out.println("IMPOSSIBLE");
        else System.out.println(time);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();

            if (graph[tmp.y][tmp.x] != tmp.now) continue;

            for (int i = 0; i < 4; i++) {
                int moveY = tmp.y + dr[i];
                int moveX = tmp.x + dc[i];

                if (moveY >= R || moveY < 0 || moveX >= C || moveX < 0) {
                    if(tmp.now == 'J') {
                        if (time > tmp.time + 1) time = tmp.time + 1;
                    }
                    continue;
                }

                if (graph[moveY][moveX] == '.') {
                    queue.add(new Node(moveY, moveX, tmp.time + 1, tmp.now));
                    graph[moveY][moveX] = tmp.now;
                } else if (graph[moveY][moveX] == 'J' && tmp.now == 'F') {
                    queue.add(new Node(moveY, moveX, tmp.time + 1, tmp.now));
                    graph[moveY][moveX] = tmp.now;
                }
            }
        }
    }

    static class Node {
        int y;
        int x;
        int time;
        char now;

        Node (int y, int x, int time, char now){
            this.y = y;
            this.x = x;
            this.time = time;
            this.now = now;
        }
    }
}
