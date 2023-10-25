package javaleetcode.huawei;

public class ListNode {

    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next=next; }

    public static void visitList(ListNode h){
        ListNode q=h;
        while (q!=null){
            if(q.next!=null)
                System.out.print(q.val+"-");
            else
                System.out.print(q.val);
            q=q.next;
        }
        System.out.println();
    }
}
