package test.boj.dp;

import org.junit.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution2(Integer.parseInt(br.readLine())));
    }

    //    1
    //        1
    //
    //    2
    //        10
    //
    //    3
    //        100
    //        101
    //
    //    4
    //        1000
    //        1010
    //        1001
    //
    //    5
    //        10000
    //        10010
    //        10100
    //        10001
    //        10101
    //
    //    6
    //        100000
    //        100010
    //        100100
    //        101000
    //        101010
    //        100001
    //        100101
    //        101001
    private static long solution2(int n) {
        if (n < 2) return 1;
        long[] dp = new long[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            // D[n]: D[n - 1] + D[n - 2]
            // D[n - 1]: n번째 자리에 0이 오는 경우
            // D[n - 2]: n번째 자리에 1이 오는 경우
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    @Test
    public void test2() {
        assertThat(solution2(1))
                .isEqualTo(1);
        assertThat(solution2(90))
                .isEqualTo(2880067194370816120L);
    }

    @Test
    public void test() {
        assertThat(solution2(1))
                .isEqualTo(1);
        // timeout
        assertThat(solution2(90))
                .isEqualTo(2880067194370816120L);
    }

    private static long solution(int n) {
        Map<Integer, List<String>> dp = new HashMap<>();
        dp.put(1, Arrays.asList("1"));

        for (int i = 2; i <= n; i++) {
            List<String> prev = dp.get(i - 1);

            List<String> now = new ArrayList<>();
            for (String prevNum : prev) {
                now.add(prevNum + "0");
                if (prevNum.endsWith("0")) {
                    now.add(prevNum + "1");
                }
            }
            dp.put(i, now);
        }

        return dp.get(n).stream().count();
    }
}
