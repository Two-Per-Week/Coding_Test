import java.util.*;

public class Main {
    static int[] heights = new int[9];
    static boolean[] visited = new boolean[9];
    static boolean isFound;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 9; i++){
            heights[i] = sc.nextInt();
        }

        combination(0, 0);
    }

    static void combination(int now, int count){
        if(isFound) return;

        if(count == 7){
            int sum = 0;
            for(int i = 0; i < 9; i++){
                if(visited[i]) sum += heights[i];
            }
            if(sum == 100){
                PriorityQueue<Integer> queue = new PriorityQueue<>();
                for(int i = 0; i < 9; i++){
                    if(visited[i]) queue.add(heights[i]);
                }
                while(!queue.isEmpty()){
                    System.out.println(queue.poll());
                }
                isFound = true;
            }
            return;
        }

        if(now > 8) return;

        if(!visited[now]) {
            visited[now] = true;
            combination(now + 1, count + 1);
            visited[now] = false;
        }
        combination(now + 1, count);
    }
}
