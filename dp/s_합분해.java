package test.boj.dp;

import org.junit.*;

import java.io.*;
import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.assertThat;

public class s_합분해 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(input);
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        bw.write(String.valueOf(solution(N, K)));

        br.close();
        bw.flush();
        bw.close();
    }

    @Test
    public void test() {
        assertThat(solution(20, 2))
            .isEqualTo(21);
        System.out.println(solution(2, 3));
    }


    //    N = 1, K = 1 -> 1 -> 1
    //    N = 1, K = 2 -> 01, 11 -> 2
    //    N = 1, K = 3 -> 001, 010, 100 -> 3
    //    N = 1, K = 4 -> 0001, 0010, 0100, 1000 -> 4
    //
    //
    //    N = 2, K = 1 -> 1 -> 1
    //    N = 2, K = 2 -> 11, 02, 20 -> 3
    //    N = 2, K = 3 -> 011, 110, 020, 002, 200, 101 -> 6
    //
    //    N = 3, K = 1 -> 1 -> 1
    //    N = 3, K = 2 -> 03, 30, 12, 21 - > 4
    //    N = 3, K = 3 -> 030, 003, 300, 012, 021, 102, 120, 201, 210, 111 -> 10
    //
    //    N = 4, K = 1 -> 1 -> 1
    //    N = 4, K = 2 -> 04, 40, 13, 31, 22 -> 5
    //    N = 4, K = 3 -> 004, 040, 400, 013, 031, 130, 103, 022, 220, 202 -> 15

    // 1    2       3           4
    // 1    3(1+1)  6(3+3)      10(6+4)
    // 1    4(1+3)  10(4+6)     20(10+10)
    // 1    5(1+4)  15(5+10)    35(15+20)
    // n = 0, dp[k][n] = 1
    // n > 0, dp[k - 1][] = dp[n - 1][k]
    private static int solution(int N, int K) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= K; i++) {
            dp[1][i] = i;
        }

        for (int n = 2; n <= N; n++) {
            for (int k = 1; k <= K; k++) {
                dp[n][k] = (dp[n][k - 1] + dp[n - 1][k]) % 1_000_000_000;
            }
        }

        return dp[N][K];
    }
}
