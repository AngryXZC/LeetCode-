package javaleetcode.dataStructureAndAlgorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ListSolution {
    /**
     * 书店店员有一张链表形式的书单，每个节点代表一本书，节点中的值表示书的编号。
     * 为更方便整理书架，
     * 店员需要将书单倒过来排列，就可以从最后一本书开始整理，逐一将书放回到书架上。请倒序返回这个书单链表。*/
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public int[] reverseBookList(ListNode head) {
        Stack<Integer> tem=new Stack<Integer>();
        while (head!=null){
            tem.push(head.val);
            head=head.next;
        }
        int[] res=new int[tem.size()];
        int i=0;
        while (!tem.empty()){
            res[i]=tem.pop();
            i++;
        }
        return  res;
    }

    /**
     * 删除链表节点
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     * */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode p=head,q=head;
        while (p!=null){
            if(p.val==val){
                if(p==head){
                    head=head.next;
                }
                else {
                    q.next=p.next;
                }
            }
            q=p;
            p=p.next;
        }
        return  head;
    }
    /**
     * 训练计划 III
     * 给定一个头节点为 head 的单链表用于记录一系列核心肌群训练编号，请将该系列训练编号 倒序 记录于链表并返回。
     *
     *  */
    public ListNode trainningPlan(ListNode head) {
        ListNode resHead=null,p=head;
        while (p!=null){
            ListNode tem=new ListNode(p.val);
            if(resHead==null){
                resHead=tem;
                tem.next=null;
            }
            else {
                tem.next=resHead;
                resHead=tem;
            }
            p=p.next;
        }
        return  resHead;

    }
    /**
     * 给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。
     *
     * 示例 1：
     *
     * 输入：head = [2,4,7,8], cnt = 1
     * 输出：8
     **/
    //快慢指针
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode fast=head,slow=head;
        for (int i=0;i<cnt;i++){
            fast=fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return  slow;
    }
    /**
     * 训练计划 IV
     * 给定两个以 有序链表 形式记录的训练计划 l1、l2，分别记录了两套核心肌群训练项目编号，请合并这两个训练计划，按训练项目编号 升序 记录于链表并返回。
     *
     * 注意：新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     */
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        ListNode resHead=new ListNode();
        ListNode p=resHead;
        while (l1!=null&&l2!=null){
            if(l1.val< l2.val){
                p.next=l1;
                p=l1;
                l1=l1.next;
            }
            else {
                p.next=l2;
                p=l2;
                l2=l2.next;
            }
            }

        if(l1==null){
            p.next=l2;
        }
        else {
            p.next=l1;
        }
        return  resHead.next;
    }
    /**
     * 训练计划 V
     * 某教练同时带教两位学员，分别以链表 l1、l2 记录了两套核心肌群训练计划，节点值为训练项目编号。两套计划仅有前半部分热身项目不同，后续正式训练项目相同。请设计一个程序找出并返回第一个正式训练项目编号。如果两个链表不存在相交节点，返回 null 。

     */
//    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//       int lA=0,lB=0;
//       ListNode a=headA,b=headB;
//       while (a!=null){
//           lA++;
//           a=a.next;
//       }
//       while (b!=null){
//           lB++;
//           b=b.next;
//       }
//       int step=Math.abs(lA-lB);
//       if(lA>lB){
//           a=headA;
//           while (step>0){
//              a=a.next;
//              step--;
//           }
//           headA=a;
//       }
//       else {
//           b=headB;
//           while (step>0){
//               b=b.next;
//               step--;
//           }
//           headB=b;
//       }
//       while (headA!=null&&headB!=null){
//           if(headA.val==headB.val){
//               break;
//           }
//           headA=headA.next;
//           headB=headB.next;
//       }
//       return headA;
//    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA,B=headB;
        while (A!=B){
            A=A!=null?A.next:headB;
            B=B!=null?B.next:headA;
        }
        return A;
    }
    /***
     * 随机链表的复制
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     *
     *  
     */
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Node cur=head;
        Map<Node,Node> nodeMap=new HashMap<>();
        while (cur!=null){
            nodeMap.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
             nodeMap.get(cur).next=nodeMap.get(cur.next);
             nodeMap.get(cur).random=nodeMap.get(cur.random);
             cur=cur.next;
        }
        return nodeMap.get(head);
    }
}
