package medium._0015;

import java.util.*;

/**
 * Created by fzy at 23:28 on 2020/12/5.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length <= 2)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i]>0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int left = i+1, right = nums.length - 1;
            while (left < right) {
                if(nums[left] + nums[right] == target){
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    left++;
                    right--;
                    while (left<right && nums[left] == nums[left-1]) left++;
                    while (left<right && nums[right] == nums[right+1]) right--;
                }else if(nums[left] + nums[right] < target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }
}
