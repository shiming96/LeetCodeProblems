class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode node = head;
        //辅助虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        while(node != null && node.next != null) {
            ListNode temp = node.next;
            node.next = node.next.next;
            temp.next = node;
            pre.next = temp;
            pre = node;
            node = node.next;
        }
        return dummyHead.next;
    }

    //------------------------------------------------
    //递归三部曲
    //  1.终止条件: 当只有一个节点或者是null的时候返回
    //  2.返回值:   返回交换完毕链表的新的头节点
    //  3.主体:     递归重复做一样的事，宏观上考虑某一步的工作，即交换头节点和他后面的一个节点。
    //------------------------------------------------
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
        
    }
}