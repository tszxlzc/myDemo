package lzc.demo.algorithm.leetcode;

public class MiddleNode {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode curr = head;
        ListNode next;
        int i= 1;
        // 迭代创建链表
        while (i<=5){
            next = new ListNode(++i);
            curr.next = next;
            curr = next;
        }

        ListNode middle = middle(head);
        System.out.print(middle);
    }

    /**
     * 把链表放到数组中
     * @param head
     * @return
     */
    public static ListNode middle(ListNode head){
        ListNode[] a = new ListNode[100];
        int i=0;
        while (head != null){
            a[i++] = head;
            head = head.next;
        }

        return a[i/2];
    }
}