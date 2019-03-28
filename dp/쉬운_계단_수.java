package test.boj.dp;

import org.junit.*;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 쉬운_계단_수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(solution(Integer.parseInt(br.readLine())) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    @Test
    public void test() {
        assertThat(solution(1))
                .isEqualTo(9);
        assertThat(solution(2))
                .isEqualTo(17);
        assertThat(solution(3))
                .isEqualTo(32);
        assertThat(solution(100))
                .isEqualTo(18404112);
    }

//    1 -> 10, 12 -> 101, 121, 123
//    2 -> 21, 23 -> 210, 212, 232, 234
//    3 -> 32, 34 -> 321, 324, 343, 346
//    4 -> 43, 45 -> 432, 434, 454, 456
//    5 -> 54, 56 -> 543, 545, 565, 567
//    6 -> 65, 67 -> 654, 656, 676, 678
//    7 -> 76, 78 -> 765, 767, 787, 789
//    8 -> 87, 89 -> 876, 878, 898
//    9 -> 98 -> 987, 989
//    1. 끝자리에 +- 1수를 추가 -> dp[N][L] = dp[N - 1][L - 1] + dp[N - 1][L + 1]
//    2. 끝자리가 0인 경우 +1만 추가 -> dp[N][L] = dp[N - 1][L + 1]
//    3. 끝 자리가 9인 경우 -1만 추가 -> dp[N][L] = dp[N - 1][L - 1]
    public static int solution(int N) {
        // 1~100 = 100 + 1 = 101 (0 예외), 1~9 = 9 + 2 = 11(0, 10 예외)
        // dp[N][L] = 길이 N, 마지막 숫자가 L인 경우의 수
        long[][] dp = new long[101][11];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            // 점화식1
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j <= 9; j++) {
                // 점화식 1, 3
                // 점화식 3. dp[N][L] = dp[N - 1][L - 1]을 따로 처리하지 않는
                // 이유는 dp[i][10]의 값은 항상 0이라 굳이 처리할 필요가 없음
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[N][i];
        }

        return (int) (sum % 1_000_000_000);
    }

    // 오답, n = 3까지만 맞음
    private static int failSolution(int N) {
        long[] dp = new long[101];
        dp[1] = 9;

        for (int i = 2; i <= N; i++) {
            dp[i] = ((dp[i - 1] * 2) - (i - 1)) % 1_000_000_000;
            System.out.println(dp[i]);
        }

        return (int) dp[N];
    }
}
