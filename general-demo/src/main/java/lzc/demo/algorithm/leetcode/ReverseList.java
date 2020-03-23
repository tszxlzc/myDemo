package lzc.demo.algorithm.leetcode;

public class ReverseList {
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


//        reverseList_1(head);
        reverseList_2(head);
    }

    /**
     * 通过迭代实现
     * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。
     * 由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
     * 在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
     * 来源：力扣（LeetCode）
     * @param head
     * @return
     */
    public static ListNode reverseList_1(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextTemp = curr.next;
            curr.next = pre;
            pre= curr;
            curr = nextTemp;
        }

        return pre;
    }

    /**
     *
     * @param head
     * @return
     */
    public static ListNode reverseList_2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode p = reverseList_2(head.next);
        head.next.next = head;
        head.next = null;
        return  p;
    }



}