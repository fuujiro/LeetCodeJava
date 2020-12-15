package medium._0003;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        int l = 0, r = 0;
        while(l<=r&&r<s.length()){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
            }else {
                set.remove(s.charAt(l));
                l++;
            }
            res = Math.max(res,r-l);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
