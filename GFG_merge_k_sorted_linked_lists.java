/*

Given K sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list.

Example 1:
  Input:
    K = 4
    value = {{1,2,3},{4 5},{5 6},{7,8}}
  Output: 1 2 3 4 5 5 6 7 8
  Explanation:
    The test case has 4 sorted linked 
    list of size 3, 2, 2, 2
    1st    list     1 -> 2-> 3
    2nd   list      4->5
    3rd    list      5->6
    4th    list      7->8
    The merged list will be
    1->2->3->4->5->5->6->7->8.

Example 2:
  Input:
    K = 3
    value = {{1,3},{4,5,6},{8}}
  Output: 1 3 4 5 6 8
  Explanation:
    The test case has 3 sorted linked
    list of size 2, 3, 1.
    1st list 1 -> 3
    2nd list 4 -> 5 -> 6
    3rd list 8
    The merged list will be
    1->3->4->5->6->8.

Your Task:
The task is to complete the function mergeKList() which merges the K given lists into a sorted one. The printing is done automatically by the driver code.

Expected Time Complexity: O(nk Logk)
Expected Auxiliary Space: O(k)
Note: n is the maximum size of all the k link list

Constraints
1 <= K <= 10^3

*/


class Solution
{
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int K)
    {
        //Add your code here.
        if(K == 0) {
            return null;
        }
        return helper(arr, K, 0, arr.length-1);
    }
    
    Node helper(Node[] arr, int K, int start, int end) {
        if(start > end) {
            return null;
        }
        
        if(start == end) {
            return arr[start];
        }
        
        int mid = (start + end) / 2;
        
        Node l1 = helper(arr, K, start, mid);
        Node l2 = helper(arr, K, mid+1, end);
        
        return mergeTwoLists(l1, l2);
    }
    
    Node mergeTwoLists(Node n1, Node n2) {
        if(n1 == null || n2 == null) {
            return n1 == null ? n2 : n1;
        }
        
        Node ans = new Node(-1);
        Node temp = ans;
        
        while(n1!=null && n2!=null) {
            if(n1.data < n2.data) {
                ans.next = n1;
                n1 = n1.next;
                ans= ans.next;
            } else {
                ans.next = n2;
                n2 = n2.next;
                ans = ans.next;
            }
        }
        ans.next = n1 == null ? n2 : n1;
        return temp.next;
    }
}
