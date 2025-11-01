# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        temp = ListNode()
        tempHead = temp
        nums.sort()
        length = len(nums)

        def is_present(num):
            l = 0
            r = length - 1

            while l <= r:
                m = (r + l) // 2
                if nums[m] == num:
                    return True
                if nums[m] > num:
                    r = m - 1
                else:
                    l = m + 1

            return False        

        while head != None:
            if not is_present(head.val):
                temp.next = head
                head = head.next
                temp = temp.next
                temp.next = None
            else:
                head = head.next

        return tempHead.next        