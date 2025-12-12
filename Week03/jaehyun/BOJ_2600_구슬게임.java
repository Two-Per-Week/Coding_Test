import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sel = new int[3];
        sel[0] = sc.nextInt();
        sel[1] = sc.nextInt();
        sel[2] = sc.nextInt();

        int[][] input = new int[5][2];
        int maxY = 0;
        int maxX = 0;

        for(int i = 0; i < 5; i++) {
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
            if(maxY < input[i][0]) maxY = input[i][0];
            if(maxX < input[i][1]) maxX = input[i][1];
        }

        char[][] D = new char[maxY+1][maxX+1];
        for (int r = 0; r <= maxY; r++) {
            for (int c = 0; c <= maxX; c++) {
                if (r == 0 && c == 0) {
                    D[0][0] = 'B';
                    continue;
                }
                int winA = 0;
                int winB = 0;
                for (int i = 0; i < 3; i++) {
                    if (r - sel[i] >= 0) {
                        if (D[r - sel[i]][c] == 'A') winB++;
                        else winA++;
                    }

                    if (c - sel[i] >= 0) {
                        if (D[r][c - sel[i]] == 'A') winB++;
                        else winA++;
                    }
                }

                if (winA == 0 && winB == 0) {
                    D[r][c] = 'B';
                } else if (winA > 0) {
                    D[r][c] = 'A';
                } else {
                    D[r][c] = 'B';
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(D[input[i][0]][input[i][1]]);
        }
    }
}
