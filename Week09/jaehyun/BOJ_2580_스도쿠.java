import java.util.*;

public class Main {
    static List<int[]> list;
    static int[][] board;
    static boolean[][] visitedY;
    static boolean[][] visitedX;
    static boolean[][][] visitedBoard;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        list = new ArrayList<>();
        board = new int[9][9];
        visitedY = new boolean[9][10];
        visitedX = new boolean[9][10];
        visitedBoard = new boolean[3][3][10];

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                board[r][c] = sc.nextInt();
                if(board[r][c] == 0) {
                    list.add(new int[]{r, c});
                } else {
                    visitedY[c][board[r][c]] = true;
                    visitedX[r][board[r][c]] = true;
                    visitedBoard[r / 3][c / 3][board[r][c]] = true;
                }
            }
        }

        dfs(0);

        print();
    }

    static void dfs(int now){
        if(now == list.size()){
            flag = true;
            return;
        }
        int[] tmp = list.get(now);
        int r = tmp[0];
        int c = tmp[1];

        for(int i = 1; i <= 9; i++){
            if(!check(r, c, i)) continue;
            visitedY[c][i] = true;
            visitedX[r][i] = true;
            visitedBoard[r / 3][c / 3][i] = true;
            board[r][c] = i;

            dfs(now + 1);
            if(flag) return;

            visitedY[c][i] = false;
            visitedX[r][i] = false;
            visitedBoard[r / 3][c / 3][i] = false;
            board[r][c] = 0;
        }
    }

    static boolean check(int r, int c, int num) {
        return !visitedY[c][num] && !visitedX[r][num] && !visitedBoard[r / 3][c / 3][num];
    }
    static void print(){
        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++){
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
}
