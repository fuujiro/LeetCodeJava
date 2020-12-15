package easy._0009;

/**
 * Created by fzy at 9:41 PM on 2020/8/31.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x >= 10 && x % 10 == 0))
            return false;
        int cut = 0;
        while (x > cut) {
            int pop = x % 10;
            x /= 10;
            cut = cut * 10 +pop;
        }
        if (x == cut || x == cut / 10)
            return true;
        else
            return false;
    }
}
