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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        ListNode tail = head;
        for(int i =0;i<k;i++){
            if(tail==null) return head;
            tail= tail.next;
        }

        ListNode newHead = rever(head,tail);
        head.next = reverseKGroup(tail,k);

        return newHead;
    }

    public ListNode rever(ListNode curr,ListNode end){
        ListNode pre = null;
        while(curr != end){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            
        }
        return pre;
    }


}