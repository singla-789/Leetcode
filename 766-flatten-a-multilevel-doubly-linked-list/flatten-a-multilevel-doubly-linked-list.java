/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr = head;

        while(curr != null){
            if(curr.child != null){
                Node next = curr.next;
                Node ctail = tail(curr.child);
                
                curr.next = curr.child;
                curr.child.prev = curr;

                if(next!= null){
                    ctail.next = next;
                    next.prev = ctail;
                }
                curr.child = null;
            }

            curr = curr.next;
        }

        return head;
    }

    public Node tail(Node head){
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        return curr;
    }
}