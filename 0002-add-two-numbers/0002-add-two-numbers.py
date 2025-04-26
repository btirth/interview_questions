# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        ansHead = ListNode()
        temp = ansHead
        carry = 0
        while l1 is not None and l2 is not None:
            sum = l1.val + l2.val + carry
            if sum >= 10:
                carry = sum / 10
                sum = sum % 10
            else:
                carry = 0    

            l1 = l1.next
            l2 = l2.next
            ansHead.next = ListNode(int(sum))  
            ansHead = ansHead.next  

        while l1 is not None:
            sum = l1.val + carry
            if sum >= 10:
                carry = sum / 10
                sum = sum % 10
            else:
                carry = 0    

            l1 = l1.next
            ansHead.next = ListNode(int(sum))  
            ansHead = ansHead.next  
            
        while l2 is not None:
            sum = l2.val + carry
            if sum >= 10:
                carry = sum / 10
                sum = sum % 10
            else:
                carry = 0    

            l2 = l2.next
            ansHead.next = ListNode(int(sum))    
            ansHead = ansHead.next

        if carry > 0:
            ansHead.next = ListNode(int(carry))   

        return temp.next