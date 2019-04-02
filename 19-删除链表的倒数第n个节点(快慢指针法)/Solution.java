class Solution {
    //---------------------------------------------
    //快慢指针一次遍历
    //虚拟头节点解决要删除的是头节点的问题
    //---------------------------------------------
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null)
            return null;
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode preSlow = new ListNode(0);
        //备用的返回节点
        ListNode retNode = preSlow;
        preSlow.next = head;
        //快指针先走n-1步
        while(n > 1) {
            fast = fast.next;
            n--;
        }
        
        //快慢指针一起走,当快指针到最后一个节点时，慢指针指向到数第n个节点
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            preSlow = preSlow.next;
        }
        
        preSlow.next = slow.next;
        slow.next = null;
        
        return retNode.next;
    }
}