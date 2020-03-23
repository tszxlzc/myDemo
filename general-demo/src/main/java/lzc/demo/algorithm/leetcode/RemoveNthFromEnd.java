package lzc.demo.algorithm.leetcode;

public class RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n){
        // 将添加一个哑结点作为辅助，该结点位于列表头部。
        // 哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部
        ListNode remove = new ListNode(0);
        remove.next = head;
        int length =0;
        ListNode first = head;
        while (first != null){
            length++;
            first = first.next;
        }

        length -=n;
        ListNode pre = remove;
        while (length>0){
            pre = pre.next;
            length--;
        }

        pre.next = pre.next.next;
        return remove.next;
    }
}