package test.boj.io;

import org.junit.*;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class 별찍기17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt()));
    }

    @Test
    public void test() {
        assertThat(solution(4)).isEqualTo(
                "   *\n" +
                "  * *\n" +
                " *   *\n" +
                "*******\n"
        );

    }

    private static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = n - (i + 1); j > 0; j--) {
                sb.append(" ");
            }

            if (i == 0) {
                sb.append("*");
            } else if (i == n - 1) {
                for (int j = 0; j < n * 2 - 1; j++) {
                    sb.append("*");
                }
            } else {
                sb.append("*");
                for (int j = 0; j < i * 2 - 1; j++) {
                    sb.append(" ");
                }
                sb.append("*");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
