package easy._0001;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by fzy at 12:21 AM on 2020/8/26.
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int div = target - nums[i];
            if (hm.containsKey(div) && hm.get(div) != i) {
                return new int[] {hm.get(div),i};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
