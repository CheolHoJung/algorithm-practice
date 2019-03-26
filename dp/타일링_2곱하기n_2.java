package test.boj.dp;

import org.junit.*;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

// refer images/타일링_2곱하기n_2.png
public class 타일링_2곱하기n_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextInt()));
    }
    
    @Test
    public void test() {
        System.out.println(solution(1));
        assertThat(solution(2))
                .isEqualTo(3);

        assertThat(solution(3))
                .isEqualTo(5);

        assertThat(solution(4))
                .isEqualTo(11);

        assertThat(solution(1000))
                .isEqualTo(7326);
    }

    private static int solution(int n) {
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10_007;
        }
        return dp[n];
    }
}
