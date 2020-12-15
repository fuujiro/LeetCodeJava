package easy._0160;

import Structure.ListNode;

/**
 * Created by fzy at 21:48 on 2020/12/6.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB){
            curA = curA != null?curA.next:headB;
            curB = curB != null?curB.next:headA;
        }
        return curA;
    }
}
