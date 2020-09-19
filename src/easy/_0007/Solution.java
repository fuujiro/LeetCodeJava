package easy._0007;

import java.util.Scanner;

/**
 * Created by fzy at 9:33 PM on 2020/8/31.
 */
public class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        System.out.println(solution.reverse(x));
    }
}
