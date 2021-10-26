/*

Given two numbers represented by two linked lists of size N and M. The task is to return a sum list.

The sum list is a linked list representation of the addition of two input numbers from the last.

Example 1:
  Input:
  N = 2
  valueN[] = {4,5}
  M = 3
  valueM[] = {3,4,5}
  Output: 3 9 0  
  Explanation: For the given two linked
  list (4 5) and (3 4 5), after adding
  the two linked list resultant linked
  list will be (3 9 0).

Example 2:
  Input:
  N = 2
  valueN[] = {6,3}
  M = 1
  valueM[] = {7}
  Output: 7 0
  Explanation: For the given two linked
  list (6 3) and (7), after adding the
  two linked list resultant linked list
  will be (7 0).

Your Task:
The task is to complete the function addTwoLists() which has node reference of both the linked lists and returns the head of the sum list.   

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(Max(N,M)) for the resultant list.

Constraints:
1 <= N, M <= 5000

*/


class Solution{
    //Function to add two numbers represented by linked list.
    class Sum {
        Node node;
        int carry;
        
        Sum(Node node, int carry) {
            this.node = node;
            this.carry = carry;
        }
    }
    
    
    Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        int l1 = getLen(first);
        int l2 = getLen(second);
        if(l2 > l1) {
            first = addPadding(first, l2-l1);
        } else if(l1 > l2) {
            second = addPadding(second, l1-l2);
        }
        
        Sum rightSum = getSum(first, second);
        if(rightSum.carry > 0) {
            Node temp = new Node(rightSum.carry);
            temp.next = rightSum.node;
            rightSum.node = temp;
        }
        
        return rightSum.node;
    }
    
    Node addPadding(Node node, int d) {
        while(d > 0) {
            Node temp = new Node(0);
            temp.next = node;
            node = temp;
            d--;
        }
        return node;
    }
    
    int getLen(Node node) {
        int l = 0;
        while(node != null) {
            l++;
            node = node.next;
        }
        
        return l;
    }
    
    Sum getSum(Node first, Node second) {
        if(first.next == null && second.next == null) {
            int value = first.data + second.data;
            return new Sum(new Node(value%10), value/10);
        }
        
        Sum rightSum = getSum(first.next, second.next);
        int value = first.data + second.data + rightSum.carry;
        Sum sum = new Sum(new Node(value%10), value/10);
        sum.node.next = rightSum.node;
        return sum;
    }
}
