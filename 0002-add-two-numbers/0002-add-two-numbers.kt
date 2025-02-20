/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var carry = 0
        var ans: ListNode = ListNode(0)
        var temp = ans
        var L1 = l1
        var L2 = l2

       

        while(L1 != null || L2 != null || carry != 0) {
            var sum = carry
            if(L1 != null) {
                sum = sum + L1.`val`
                L1 = L1.next
            }

            if(L2 != null) {
                sum += L2.`val`
                L2 = L2.next
            }

          
            ans.next = ListNode(sum % 10)
            ans = ans.next
            carry = sum / 10    
          
        }

        return temp.next
    }
}