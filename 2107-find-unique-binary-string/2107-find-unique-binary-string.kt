class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
        return helper("", nums) ?: ""
    }

    fun helper(s: String, nums: Array<String>): String? {
        if(s.length == nums[0].length) {
            if(nums.contains(s)) {
                return null
            }

            return s
        }

        return helper(s + "1", nums) ?: helper(s + "0", nums)
    }
}