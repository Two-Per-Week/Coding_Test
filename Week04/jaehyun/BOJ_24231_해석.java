import java.util.*;

public class Main {
    static long[][] D;
    static char[] s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int size = S.length();
        s = new char[size];

        for (int i = 0; i < size; i++) {
            s[i] = S.charAt(i);
        }

        D = new long[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(D[i], -1);
        }

        System.out.println(dp(0, size-1));
    }

    static long dp(int start, int end) {
        if (start > end) return 1;

        if ((end - start + 1) % 2 == 1) return 0;

        if (D[start][end] != -1) return D[start][end];

        long count = 0;

        for (int i = start + 1; i <= end; i += 2) {
            if (s[start] !=  s[i]) {
                long in = dp(start + 1, i - 1);
                long out = dp(i + 1, end);

                count = (count + (in * out)) % 1_000_000_007;
            }
        }

        return D[start][end] = count;
    }
}
