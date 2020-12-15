package medium._0215;

import java.util.PriorityQueue;

/**
 * Created by fzy at 15:57 on 2020/12/4.
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            if(priorityQueue.size()<k){
                priorityQueue.add(num);
            }else {
                if(num>priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.add(num);
                }
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(solution.findKthLargest(nums,k));
    }
}
