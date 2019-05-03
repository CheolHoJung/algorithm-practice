package test.boj.dp;

import org.junit.*;

import java.io.*;

// https://mizzo-dev.tistory.com/entry/baekjoon2133 참고
public class q_타일_채우기 {

    @Test
    public void test() {
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(30));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(solution(N)));

        br.close();
        bw.flush();
        bw.close();
    }

    // dp[2] = 3
    // dp[2]는 고유조합이 없으므로 3을 사용
    // 나머지는 고유조합이 2개씩 존재

    // dp[4] = dp[2] dp[2] = dp[2] * dp[2] = 9
    //         dp[4]의 고유 조합 = 2
    //         9 + 2 = 11

    // 1. dp[4]를 치환해보자.
    // dp[2] dp[4] = dp[2] (dp[2] dp[2])
    //               dp[2] (dp[4]의 고유 조합)
    // dp[2] (dp[2] dp[2])에서 dp[2]를 괄호 뒤로 뗴어 붙일 수가 없다
    // 반면, dp[2] (dp[4]의 고유 조합)는 (dp[4]의 고유 조합) dp[2]처럼 괄호 뒤로 뗴어 붙일 수가 있다.

    // dp[6]으로 돌아와서
    // dp[6] = dp[2] dp[4]
    //         dp[6]의 고유 조합
    // 1.에서 (dp[4]의 고유 조합)이 뒤에 한번밖에 사용되지 않았다. 앞에도 사용하자.

    // dp[6] = dp[2] dp[2] dp[2]
    //         dp[2] (dp[4]의 고유 조합)
    //         (dp[4]의 고유 조합) dp[2]
    //         dp[6]의 고유 조합
    //
    // dp[2] dp[2] dp[2]과 dp[2] (dp[4]의 고유 조합)은 dp[2] dp[4]이므로 dp[6]을 다시 정리하면 다음과 같다.
    // dp[2]는 (dp[2]의 고유조합)과 같다
    // dp[6] = dp[2] dp[4] = 3 * 11 = 33
    //         (dp[4]의 고유 조합) dp[2] = 2 * 3 = 6
    //         (dp[6]의 고유 조합) = 2
    //         33 + 6 + 2 = 41
    public static int solution(int N) {
        if (N < 2) return 0;

        int[] dp = new int[N + 1];
        // dp[i - j]에서 dp[0]에 접근하기 때문에 1로 설정
        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= N; i+=2) {
            for (int j = 2; j <= i; j += 2) {
                int std = j == 2 ? 3 : 2;
                dp[i] += std * dp[i - j];
            }
        }

        return dp[N];
    }
}
