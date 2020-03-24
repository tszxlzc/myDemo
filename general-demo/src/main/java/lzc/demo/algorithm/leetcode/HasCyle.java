package lzc.demo.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HasCyle {
    public static void main(String[] args) {

    }

    public static boolean isCycle(ListNode head){
        Set<ListNode> nodeSeen = new HashSet<>();
        while (head != null){
            if(nodeSeen.contains(head)){
                return true;
            }
            nodeSeen.add(head);
            head = head.next;
        }

        return false;
    }
}