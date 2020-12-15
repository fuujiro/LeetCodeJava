package hard._0025;

import Structure.ListNode;

/**
 * Created by fzy at 16:18 on 2020/12/4.
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            //剩余数量小于k的话，则不需要反转。
            if (tail == null)
                return head;
            tail = tail.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(head, tail);
        //下一轮的开始的地方就是tail
        head.next = reverseKGroup(tail, k);
        return newHead;
    }
    /*
    左闭又开区间
     */
    private ListNode reverse(ListNode head, ListNode tail){
        ListNode prev = null;
        ListNode next = null;
        while (head != tail){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
