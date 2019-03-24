package test.boj.io;

import org.junit.*;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class Year2007 {

    @Test
    public void test() {
        assertThat(solution(1, 1))
                .isEqualTo("MON");

        assertThat(solution(3, 14))
                .isEqualTo("WED");

        assertThat(solution(9, 2))
                .isEqualTo("SUN");

        assertThat(solution(12, 25))
                .isEqualTo("TUE");
    }

    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] dayStrs = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextInt(), sc.nextInt()));
    }

    public static String solution(int x, int y) {
        int diff = y;

        for (int i = x - 1; i >= 1; i--) {
            diff += days[i];
        }

        return dayStrs[diff % 7];
    }
}
