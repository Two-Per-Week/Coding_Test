import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Assignment> queue = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            queue.add(new Assignment(sc.nextInt(), sc.nextInt()));
        }

        boolean[] d = new boolean[1001];
        int sum = 0;
        while(!queue.isEmpty()){
            Assignment tmp = queue.poll();
            for(int i = tmp.expire; i >= 1; i--){
                if(!d[i]){
                    d[i] = true;
                    sum += tmp.score;
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    static class Assignment implements Comparable<Assignment>{
        int expire;
        int score;

        public Assignment(int expire, int score){
            this.expire = expire;
            this.score = score;
        }

        @Override
        public int compareTo(Assignment o) {
            if(o.score == this.score){
                return this.expire - o.expire;
            }
            return o.score - this.score;
        }
    }
}
