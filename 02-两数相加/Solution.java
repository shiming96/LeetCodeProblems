/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    //--------------------------------------------------
    // 1.   首先想到转换为数据类型相加，再转回链表，但测试数据会很大，一定会溢出
    // 2.   直接每一个节点相加，考虑进位    
    //--------------------------------------------------
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        int pre = 0;    //进位
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = pre + x + y;
            pre = sum / 10;
            res.next = new ListNode(sum % 10);
            res = res.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        
        if(pre > 0)
            res.next = new ListNode(pre);
        
        return head.next;
    }
}