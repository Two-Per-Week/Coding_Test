import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);

       N = sc.nextInt();
       K = sc.nextInt();

       StringBuilder sb = new StringBuilder();
       for(int i = 0; i < N; i++){
        sb.append(sc.nextInt());
       }
       String text = sb.toString();

       System.out.println(bfs(text));
    }

    static int bfs(String orgText){
        Queue<String[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(orgText);
        queue.add(new String[]{orgText, String.valueOf(0)});
        
        while(!queue.isEmpty()){
            String[] tmp = queue.poll();
            String text = tmp[0];
            int count = Integer.parseInt(tmp[1]);

            for(int i = 1; i <= text.length(); i++){
                if(text.charAt(i - 1) - '0' != i){
                    break;
                }

                if(i == text.length() - 1){
                    return count;
                }
            }

            for(int i = 0; i < text.length() - (K - 1); i++){
                String tmpText = flip(i, text);
                if(!visited.contains(tmpText)){
                    visited.add(tmpText);
                    queue.add(new String[]{tmpText, String.valueOf(count + 1)});
                }
            }
        }
        return -1;
    }

    static String flip(int idx, String text){
        StringBuilder sb = new StringBuilder();
        sb.append(text, 0, idx);
        for(int i = idx + K - 1; i >= idx; i--){
            sb.append(text.charAt(i));
        }
        sb.append(text.substring(idx + K));
        return sb.toString();
    }
}
