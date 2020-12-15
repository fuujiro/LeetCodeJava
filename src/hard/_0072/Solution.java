package hard._0072;

/**
 * Created by fzy at 0:41 on 2020/12/13.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m*n == 0)
            return n+m;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n+1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                int left = dp[i-1][j] + 1;
                int down = dp[i][j-1] + 1;
                int left_down = dp[i-1][j-1];
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    left_down+=1;
                }
                dp[i][j] = Math.min(left,Math.min(down,left_down));
            }
        }
        return dp[m][n];
    }
}
