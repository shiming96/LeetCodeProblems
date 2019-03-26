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
    // 保留重复节点
    //--------------------------------------------------

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode p = head;
        while(p != null && p.next != null) {
            if(p.next.val == p.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    //--------------------------------------------------
    // 既可保留重复节点，也可以不保留。
    //--------------------------------------------------
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null)
            return null;
        ListNode node = new ListNode(Integer.MIN_VALUE);
        node.next = head;
        ListNode pre = node;
        ListNode p = head;
        boolean delMode = false;
        while(p != null) {
            if(p.next != null && p.next.val == p.val) {
                p.next = p.next.next;
                delMode = true;                
            } else if(delMode) {
                //pre.ext = p.next; 不保留重复节点   
                pre.next = p;   //保留重复节点
                delMode = false;
            } else {
                pre = p;
                p = p.next;
            }
        }
        return node.next;
    }



    //-------------------------递归法解决链表问题--------------------


    //--------------------------------------------------
    // 不优雅的递归
    //--------------------------------------------------
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        //如果是重复节点
        if(head.next.val == head.val) {
            ListNode node = head.next;
            ListNode pre = node;//记录node的前一个节点，即保留重复节点
            while(node.next != null && node.val == head.val) {  //寻找第一个不重复的节点node
                pre = node;
                node = node.next;
            }
            return deleteDuplicates(pre);
        } else {//不是重复节点，从该节点的下一个节点开始递归
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    //--------------------------------------------------
    // 不优雅的递归
    //  递归三部曲:
    //      1.递归终止条件   2.递归宏观语义实现(主体)   3.递归返回值
    //      leetcode-203
    //-------------------------------------------------- 
    public ListNode deleteDuplicates2(ListNode head) {
        //递归终止条件  当到链表末尾或只剩一个节点的时候，不可能重复
        if(head == null || head.next == null)
            return head;
        
        //递归的宏观语义：返回的是已经去重的链表
        head.next = deleteDuplicates(head.next);
        
        //head.next已经去重了,最后需要判断head和head.next是否相等，是的话需要跳过
        if(head.val == head.next.val)
            head = head.next;
        
        //递归返回值：  返回已去重链表的头节点
        return head;
    }

}