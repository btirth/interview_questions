class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var map = hashMapOf<Int, Int>()

        for(i in nums.indices) {
            var requiredVal = target - nums[i]
            if(map.containsKey(requiredVal)) {
                return intArrayOf(map[requiredVal]!!, i)
            }

            map[nums[i]] = i
        }

        return intArrayOf(0,0)
    }
}