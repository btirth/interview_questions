/*
// Definition for a Node.
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
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node tempHead = head;

        while(head != null) {
            Node next = new Node(head.val);
            next.next = head.next;
            head.next = next;
            head = head.next.next;
        }

        head = tempHead;
        while(head != null) {   
            if(head.random != null)
                head.next.random = head.random.next;
            head = head.next.next;
        }

        Node ans = new Node(0);
        Node holdAns = ans;
        head = tempHead;

        while(head != null) {
            ans.next = head.next;
            ans = ans.next;
            head.next = head.next.next;
            head = head.next;
        }

        return holdAns.next;
    }
}