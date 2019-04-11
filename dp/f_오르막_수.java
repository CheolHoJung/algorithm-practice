package test.boj.dp;

import org.junit.*;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class f_오르막_수 {
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
                .isEqualTo(10);
        assertThat(solution(2))
                .isEqualTo(55);
        assertThat(solution(3))
                .isEqualTo(220);
    }

    // N = 1
    // 0
    // 1
    // 2
    // 3
    // 4
    // 5
    // 6
    // 7
    // 8
    // 9
    //
    // N = 2 -> 55개
    // 00, 01, 02, 03, 04, 05, 06, 07, 08, 09 - 10개 -> N = 3: sum(1..10) - 55
    // 11, 12, 13, 14, 15, 16, 17, 18, 19 - 9개 -> N = 3: sum(1..9) - 45
    // 22, 23, 24, 25, 26, 27, 28, 29 - 8개 -> N = 3: sum(1..8) - 36
    // 33, 34, 35, 36, 37, 38, 39 - 7개 -> N = 3: 28
    // 44, 45, 46, 47, 48, 49 - 6개 -> N = 3: 21
    // 55, 56, 57, 58, 59 - 5개 -> N = 3: 15
    // 66, 67, 68, 69 - 4개 -> N = 3: 10
    // 77, 78, 79 - 3개 -> N = 3: 6
    // 88, 89 - 2개 -> N = 3: 3
    // 99 - 1개 -> N = 3: sum(1..1) 1
    //
    // N = 3, 첫번 째 00 ~ 09에서만 55개 sum(sum(1..1) +....+ sum(1..10))
    // 000, 001, 002, 003, 004, 005, 006, 007, 008, 009
    // 011, 012, 013, 014, 015, 016, 017, 018, 019
    // 022, 023, 024, 025, 026, 027, 028, 029
    // 033, 034, 035, 036, 037, 038, 039
    // 044, 045, 046, 047, 048, 049
    // 055, 056, 057, 058, 059
    // 066, 067, 068, 069
    // 077, 078, 079
    // 088, 089
    // 099
    // N = 1 -> dp[N][L] = 1
    // N > 1 -> dp[N][L] = dp[N - 1][L] + dp[N - 1][L + 1] + ...... L <= 9
    private static int solution(int n) {
        long[][] dp = new long[1001][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int N = 2; N <= n; N++) {
            dp[N][9] = 1;
            for (int L = 0; L <= 9; L++) {
                for (int M = L; M <= 9; M++) {
                    dp[N][L] += dp[N - 1][M];
                }
                dp[N][L] %= 10_007;
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }
        return sum % 10_007;
    }

    @Test
    public void test2() {
        assertThat(solution2(1))
                .isEqualTo(10);
        assertThat(solution2(2))
                .isEqualTo(55);
        assertThat(solution2(3))
                .isEqualTo(220);
    }

    // dp[N][L + 1]은 dp[N][L]에서 맨 윗 계단(9개)을 떼어낸 것으로 볼 수 있다.
    // N = 4, L = 1
    // 111, 112, 113, 114, 115, 116, 117, 118, 119 <- dp[4][2]는 이 부분을 떼어낸 모습(9개)
    // 122, 123, 124, 125, 126, 127, 128, 129
    // 133, 134, 135, 136, 137, 138, 139
    // 144, 145, 146, 147, 148, 149
    // 155, 156, 157, 158, 159
    // 166, 167, 168, 169
    // 177, 178, 179
    // 188, 189
    // 199
    // N = 4, L = 2
    // 222, 223, 224, 225, 226, 227, 228, 229
    // 233, 234, 235, 236, 237, 238, 239
    // 244, 245, 246, 247, 248, 249
    // 255, 256, 257, 258, 259
    // 266, 267, 268, 269
    // 277, 278, 279
    // 288, 289
    // 299

    // 떼어진 맨 윗 계단은 dp[N - 1][L]와 같은 모양이므로 해당 계단을 떼어서 맨 위로 붙이면 dp[N][L]이 완성된다.
    // N = 3, L = 1
    // 00, 01, 02, 03, 04, 05, 06, 07, 08, 09 (9개)
    // N = 1 -> dp[N][L] = 1
    // N > 1 && L == 9 -> dp[N][L] = 1
    //       && L <= 8 -> dp[N][L] = dp[N][L + 1] + dp[N - 1][L]
    private static int solution2(int n) {
        long[][] dp = new long[1001][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int N = 2; N <= n; N++) {
            dp[N][9] = 1;
            for (int L = 8; L >= 0; L--) {
                dp[N][L] = dp[N - 1][L] + dp[N][L + 1];
                dp[N][L] %= 10007;
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }
        return sum % 10_007;
    }
}
