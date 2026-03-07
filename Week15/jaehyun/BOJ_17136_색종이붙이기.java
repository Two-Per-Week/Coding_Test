import java.util.*;

public class Main {
    static int[][] board;
    static int[] colorPaper;
    static int minCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        board = new int[10][10];

        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                board[r][c] = sc.nextInt();
            }
        }

        minCount = Integer.MAX_VALUE;
        colorPaper = new int[6];
        Arrays.fill(colorPaper, 5);
        dfs(0, 0, 0);

        if(minCount == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minCount);
    }

    static void dfs(int nowY, int nowX, int count){
        if(count >= minCount) return;

        if(nowY == 10){
            minCount = count;
            return;
        }

        if(nowX == 10){
            dfs(nowY + 1, 0, count);
            return;
        }

        if(board[nowY][nowX] == 0) {
            dfs(nowY, nowX + 1, count);
            return;
        }

        for(int size = 5; size > 0; size--){
            if(check(nowY, nowX, size)){
                change(nowY, nowX, size, 0);
                dfs(nowY, nowX + 1, count + 1);
                change(nowY, nowX, size, 1);
            }
        }
    }

    static boolean check(int nowY, int nowX, int size){
        if(colorPaper[size] == 0) return false;
        if(nowY + size > 10 || nowX + size > 10) return false;

        for(int r = nowY; r < nowY + size; r++){
            for(int c = nowX; c < nowX + size; c++){
                if(board[r][c] == 0) return false;
            }
        }
        return true;
    }

    static void change(int nowY, int nowX, int size, int target){
        if(target == 0){
            colorPaper[size]--;
        } else if(target == 1){
            colorPaper[size]++;
        }

        for(int r = nowY; r < nowY + size; r++){
            for(int c = nowX; c < nowX + size; c++){
                board[r][c] = target;
            }
        }
    }
}
