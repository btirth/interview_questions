# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        queue = []
        queue.append(root) 
        max_sum = float('-inf')
        max_sum_level = 1
        level = 1

        while len(queue) > 0:
            next_level = []
            size = len(queue)
            level_sum = 0

            while size > 0:
                node = queue.pop()
                level_sum += node.val

                if node.left:
                    next_level.append(node.left)
                
                if node.right:
                    next_level.append(node.right)

                size -= 1
            print(f"{level} {level_sum}")
            if level_sum > max_sum:
                max_sum = level_sum
                max_sum_level = level

            queue = next_level
            level += 1
        
        return max_sum_level
