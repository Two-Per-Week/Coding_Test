import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[] multiTab = new boolean[K+1];
        int[] order = new int[K+1];
        PriorityQueue<Integer>[] products = new PriorityQueue[K+1];
        for(int i = 1; i <= K; i++){
            products[i] = new PriorityQueue<>();
        }
        for(int i = 1; i <= K; i++){
            order[i] = sc.nextInt();
            products[order[i]].add(i);
        }

        int multiTabCount = 0;
        int count = 0;
        loop: for(int i = 1; i <= K; i++){
            products[order[i]].poll();
            if(!multiTab[order[i]]){
                if(multiTabCount == N){
                    int max = 0;
                    int maxNum = 0;
                    for(int j = 1; j <= K; j++){
                        if(order[i] == j) continue;
                        if(!multiTab[j]) continue;

                        if(products[j].isEmpty()){
                            multiTab[j] = false;
                            multiTab[order[i]] = true;
                            count++;
                            continue loop;
                        }

                        int tmp = products[j].peek();
                        if(tmp > max){
                            max = tmp;
                            maxNum = j;
                        }
                    }

                    multiTab[maxNum] = false;
                    multiTab[order[i]] = true;
                    count++;
                } else {
                    multiTabCount++;
                    multiTab[order[i]] = true;
                }
            }
        }
        System.out.println(count);
    }
}
