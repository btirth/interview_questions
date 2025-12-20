class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        no_of_columns = len(strs[0])
        no_of_rows = len(strs)
        deletion_size = 0

        for col in range(0, no_of_columns):
            for row in range(1, no_of_rows):
                if strs[row][col] < strs[row - 1][col]:
                    deletion_size += 1
                    break
              
        return deletion_size