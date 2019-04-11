package test.boj.dp;

import org.junit.*;

import java.util.Scanner;

public class b_타일링_2곱하기n {

    @Test
    public void test() {
        System.out.println(solution(1000));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextInt()));
    }

    // n:    0 1 2 3 4 5 6  7  8  9 ....
    // F(n): 1 1 2 3 5 8 13 21 34 55 .....
    private static int solution(int n) {
        return f(n);
    }

    private static int f(int n) {
        int[] fibo = new int[n + 1];
        fibo[0] = fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            // !!! overflow -> % 10007
            fibo[i] = (fibo[i - 1] + fibo[i -  2]) % 10007;
        }
        return fibo[n];
    }
}
