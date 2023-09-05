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
        Node copyHead = head;
        Node nextNode = head;
        // Step 1: create copy nodes
        while(copyHead != null) {
            nextNode = copyHead.next;
            copyHead.next = new Node(copyHead.val);
            copyHead.next.next = nextNode;
            copyHead = nextNode;
        }
        
        // Step 2: point the random pointer
        copyHead = head;
        nextNode = head;
        while(copyHead != null && copyHead.next != null) {
            if(copyHead.random != null) {
                copyHead.next.random = copyHead.random.next;    
            }
            
            copyHead = copyHead.next.next;
        }
        
        // Step 3: remove copy nodes
        copyHead = head;
        nextNode = head;
        Node newHead = new Node(0);
        Node newCopyHead = newHead;
        
        while(copyHead != null) {
            nextNode = copyHead.next.next;
            newCopyHead.next = copyHead.next;
            newCopyHead = newCopyHead.next;
            
            copyHead.next = nextNode;
            copyHead = nextNode;
        }
        
        
        return newHead.next;
    }
}