package lzc.demo.algorithm.leetcode;

public class MergeTwoList {
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

        ListNode merged = mergeTwoLists(head,null);
    }

    /**
     * 合并K个排序链表
     * @param lists
     * @return
     */
    public static ListNode mergeLists(ListNode[] lists){
        int lenth = lists.length;
        if(lenth == 0) {
            return null;
        }
        int i;
        while (lenth > 1){
            for (i=0; i<lenth/2; i++){
                lists[i] = mergeTwoLists(lists[i * 2],lists[i*2 +1]);
            }

            // 处理数组大小是奇数的情况
            if(lenth%2 !=0){
                lists[i] = lists[lenth - 1];
                lenth ++;
            }

            lenth/=2;
        }

        return lists[0];
    }

    public static  ListNode mergeTwoLists(ListNode list1,ListNode list2){
        // 设置一个合并后链表的前置节点
        ListNode prehead = new ListNode(-1);
        ListNode pre = prehead;
        while (list1 != null && list2 !=null){
            if(list1.val < list2.val){
                pre.next = list1;
                list1 = list1.next;
            }else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }

        pre.next = list1 == null? list2 : list1;

        return prehead.next;
    }
}