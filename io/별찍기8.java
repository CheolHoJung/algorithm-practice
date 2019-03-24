package test.boj.io;

import org.junit.*;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class 별찍기8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt()));
    }

    @Test
    public void test() {
        assertThat(solution(5)).isEqualTo(
                "*        *\n" +
                "**      **\n" +
                "***    ***\n" +
                "****  ****\n" +
                "**********\n" +
                "****  ****\n" +
                "***    ***\n" +
                "**      **\n" +
                "*        *\n"
        );
    }

    private static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int line = n * 2 - 1;
        int star = 1;
        int space = n * 2 - 2;

        for (int i = 0; i < line; i++) {
            for (int j = 0; j < star; j++) {
                sb.append("*");
            }
            for (int j = 0; j < space; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < star; j++) {
                sb.append("*");
            }

            if (i >= line / 2) {
                star--;
                space += 2;
            } else {
                star++;
                space -= 2;
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
