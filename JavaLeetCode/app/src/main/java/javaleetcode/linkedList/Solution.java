package javaleetcode.linkedList;


/**
 * @author xzc
 * @date 2024/7/1 10 27:56
 * @description
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * 203
    * */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead=new ListNode();
        dummyHead.next=head;
        ListNode prev=dummyHead;
        while (prev.next!=null)
        {
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }
            else {
                prev=prev.next;
            }
        }
        return dummyHead.next;
    }
    /**
     * 206. 反转链表
     * */
    //非递归
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
    //递归
    public ListNode reverseListR(ListNode head) {
        if(head==null||head.next==null)
            return head;
        //翻转
        ListNode rev=reverseListR(head.next);
        //翻转后的最后一个节点仍然可以通过head访问
        //将head接入
        head.next.next=head;
        //将head的next置为空
        head.next=null;
        return  rev;
    }
}
