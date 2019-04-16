package test.boj.dp;

import org.junit.*;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

// https://cheolhojung.github.io/posts/algorithm/boj- sum-of-squares.html
public class p_제곱수의_합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(solution2(Integer.parseInt(br.readLine()))));

        bw.flush();
        bw.close();
        br.close();
    }

    @Test
    public void test() {
//        assertThat(solution2(7))
//                .isEqualTo(4);
//        assertThat(solution2(11))
//                .isEqualTo(3);
//        assertThat(solution2(12))
//                .isEqualTo(3);
//        assertThat(solution2(100_000))
//                .isEqualTo(2);
//        assertThat(solution2(10_000))
//                .isEqualTo(1);
        assertThat(solution2(142))
                .isEqualTo(3);
    }

    private static int solution2(int n) {
        int [] dp = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            dp[i] = i;
            for(int j = 1, pow = j * j; pow <= i; j++, pow = j * j)
                if(dp[i] > dp[i - pow] + 1)
                    dp[i] = dp[i - pow] + 1;
        }
        return dp[n];
    }

    // n이 제곱이면 dp[n] = 2
    // n이 제곱이 아니라면, (n - i => i) dp[n] = min((dp[n - 1] + dp[1]) .... dp[n - i] + dp[i])
    private static int solution(int n) {
        final int MAX_SQUARE = 100_001;
        final int MAX_SQRT = (int) Math.sqrt(MAX_SQUARE);
        boolean[] isSquare = new boolean[MAX_SQUARE];
        int[] dp = new int[n + 1];

        isSquare[1] = true;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (isSquare[i]) {
                dp[i] = 1;
            } else {
                dp[i] = getMin(dp, i);
            }

            if (i <= MAX_SQRT) {
                isSquare[i * i] = true;
            }
        }

        return dp[n];
    }

    private static int getMin(int[] dp, int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; n - i >= i; i++) {
            min = Math.min(min, dp[n - i] + dp[i]);
        }
        return min;
    }
}
