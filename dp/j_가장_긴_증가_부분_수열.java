package test.boj.dp;

import org.junit.*;

import java.io.*;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class j_가장_긴_증가_부분_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(("0 " + br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(n, numbers));

        br.close();
        bw.flush();
        bw.close();
    }

    @Test
    public void test() {
        assertThat(solution(6, new int[]{0, 10, 20, 10, 30, 20, 50}))
            .isEqualTo(4);
    }

    // 자신보다 작은 숫자들의 부분수열에서 길이가 가장 큰 경우를 구해야 한다. -> dp[i - 1], Math.max 사용
    // 자신보다 작은 숫자들의 부분수열에서 길이가 같은 경우는 하나만 선택해도 상관없다.

    // maxLengthOfSmallerNumbers(i) = numbers[i]보다 작은 숫자들의 부분수열에서 길이가 가장 큰 부분수열의 길이
    // dp[i] = maxLengthOfSmallerNumbers(i) + 1

    // i       0   1    2   3   4   5   6
    // numbers 0 | 10   20  10  30  20  50
    // dp      0 | 1    2   1   3   2   4
    private static int solution(int n, int[] numbers) {
        int[] dpOfLength = new int[1_010];
        int maxLength = 0;

        for (int i = 1; i <= n; i++) {
            dpOfLength[i] = maxLengthOfSmallerNumbers(dpOfLength, numbers, i) + 1;
            maxLength = Math.max(maxLength, dpOfLength[i]);
        }
        return maxLength;
    }

    private static int maxLengthOfSmallerNumbers(int[] dpOfLength, int[] numbers, int i) {
        int result = 0;
        int now = numbers[i];
        for (int j = 1; j < i; j++) {
            int prev = numbers[j];
            if (now > prev) {
                result = Math.max(result, dpOfLength[j]);
            }
        }
        return result;
    }

    // 다음 코드처럼 dp 배열에 오름차순 수열을 만들어버리는 방법도 있다.
    // 앞 단계에서 큰 숫자가 dp에 저장된다 하더라도
    // D[j] >= A[i] 조건에 의해 다시 작은 숫자로 갱신된다.
    //      for (int i = 0; i < N; i++) {
    //			D[i] = Integer.MAX_VALUE;
    //		}
    //
    //		for (int i = 0; i < N; i++) {
    //			for (int j = 0; j < D.length; j++) {
    //				if (D[j] >= A[i]) {
    //					D[j] = A[i];
    //					break;
    //				}
    //			}
    //		}
    //
    //		for (int j = 0; j < D.length; j++) {
    //			if (D[j] < Integer.MAX_VALUE && D[j] > 0) {
    //				count++;
    //			}
    //		}
    // Ex) dp = [1 2 3, .......], 정답 3
    //  index       0   1   2   3   4   5   6   7   8   9   10
    //  nums        3	1	1	2	1	1	1	1	1	1	3
    //  i=0, j=0    3
    //  i=1, j=0    1 <- 앞단계에서 3이 저장되더라도 i = 1, j = 0인 시점에서
    //                   if (D[j] >= A[i]) { D[j] = A[i]; } 구문에 의해 더 작은 수인 1로 교체된다.
    //                   -> D[j] = 3, A[i] = 1
    //  i=2, j=1    1   2
    //  i=10, j=3   1   2   3 <- 종료, 정답 3개
}
