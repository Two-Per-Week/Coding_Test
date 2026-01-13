import java.util.*;

public class Main {
    static int[][] nodes;
    static int[][] minMax;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        nodes = new int[N+1][2]; // left, right
        int[] parent = new int[N + 1];
        for(int i = 0; i < N; i++){
            int now = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();
            nodes[now][0] = left;
            nodes[now][1] = right;

            if (left != -1) parent[left] = now;
            if (right != -1) parent[right] = now;
        }

        int root = 0;
        for (int i = 1; i <= N; i++) {
            if (parent[i] == 0) {
                root = i;
                break;
            }
        }

        minMax = new int[N+1][2]; // min max
        for (int i = 1; i <= N; i++) {
            minMax[i][0] = Integer.MAX_VALUE;
        }

        count = 1;
        inOrder(root, 1);

        int level = 1;
        int maxWidth = 0;
        for (int i = 1; i <= N; i++) {
            if(minMax[i][0] == Integer.MAX_VALUE) break;
            int width = minMax[i][1] - minMax[i][0] + 1;
            if (width > maxWidth) {
                maxWidth = width;
                level = i;
            }
        }
        System.out.println(level + " " + maxWidth);
    }

    // 전위 순회
    static void inOrder(int now, int level) {
        if (now == -1) return;
        inOrder(nodes[now][0], level + 1); // left

        minMax[level][0] = Math.min(minMax[level][0], count);
        minMax[level][1] = Math.max(minMax[level][1], count);
        count++;

        inOrder(nodes[now][1], level + 1); // right
    }
}
