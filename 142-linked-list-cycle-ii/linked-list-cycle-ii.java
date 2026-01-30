/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        boolean flag = false;
        while(f != null && f.next != null ){
            s = s.next;
            f = f.next.next;
            if(f==s){
                flag = true;
                s = head;
                break;
            }
        }

        if(flag){
            while(f!=s){
                s = s.next;
                f = f.next;
            }
            return f;
        }

        return null;   
    }
}