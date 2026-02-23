import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Map<String, Integer> visited = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String init = "";
        for (int i = 0; i < 9; i++) {
            init += sc.next();
        }

        System.out.println(bfs(init));
    }

    static int bfs(String init) {
        Queue<String> queue = new LinkedList<>();
        queue.add(init);
        visited.put(init, 0);

        while (!queue.isEmpty()) {
            String now = queue.poll();
            int count = visited.get(now);

            if ("123456780".equals(now)) return count;

            int zeroIdx = now.indexOf('0');
            int r = zeroIdx / 3;
            int c = zeroIdx % 3;

            for (int i = 0; i < 4; i++) {
                int moveY = r + dr[i];
                int moveX = c + dc[i];

                if (moveY >= 0 && moveY < 3 && moveX >= 0 && moveX < 3) {
                    int nextIdx = moveY * 3 + moveX;
                    String next = swap(now, zeroIdx, nextIdx);

                    if (!visited.containsKey(next)) {
                        visited.put(next, count + 1);
                        queue.add(next);
                    }
                }
            }
        }
        return -1;
    }

    static String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        
        StringBuilder sb = new StringBuilder();
        for(char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}
