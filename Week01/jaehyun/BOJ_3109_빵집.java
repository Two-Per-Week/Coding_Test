import java.util.*;

public class Main {
    //  우상, 우, 우하
    static int[] dr = {-1, 0, 1};
    static int[] dc = {1, 1, 1};
    static int R, C;
    static char[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        graph = new char[R][C];
        for (int r = 0; r < R; r++) {
            String s = sc.next();
            for (int c = 0; c < C; c++) {
                graph[r][c] = s.charAt(c);
            }
        }

        int result = 0;
        for (int r = 0; r < R; r++) {
            if (graph[r][0] == '.') {
                result += dfs(r, 0);
            }
        }

        System.out.println(result);
    }

    static int dfs(int nowY, int nowX) {
        for (int i = 0; i < 3; i++) {
            int moveY = nowY + dr[i];
            int moveX = nowX + dc[i];

            if (0 > moveY || moveY >= R || 0 > moveX || moveX >= C) continue;

            if (graph[moveY][moveX] == '.') {
                graph[moveY][moveX] = 'X';

                if (moveX == C-1) return 1;

                if (dfs(moveY, moveX) == 1) return 1;
            }
        }
        return 0;
    }
}
