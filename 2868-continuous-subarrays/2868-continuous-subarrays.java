class Solution {
    public long continuousSubarrays(int[] nums) {
        /*
            Sliding window
            left = 0
            right = 0
            minDeque -> to keep track of min and max
            maxDeque

            while(right < length) {
                while(!minDeque empty && minDeque.last > nums[right]) {
                    minDeque.pop()
                }
                minDeque.add(nums[right])

                while(!maxDeque empty && maxDeque.last < nums[right]) {
                    maxDeque.pop()
                }
                maxDeque.add(nums[right])

                NOW: first value in minDeque is minimum num is min number and max in maxDeque
                while(left<right && Math.abs(minDeque.peek() - maxDeque.peek()) > 2) {
                    if(minDeque.peekFirst() == nums[left]) {
                        minDeque.removeFirst()
                    }

                    if(maxDeque.peekFirst() == nums[left]) {
                        maxDeque.removeFirst()
                    }

                    left++;
                }

                ans = Math.max(ans, right - left + 1);
                right++;
            }



            [5,4] = [5,4]
            [1,2,2] = [1] [1,2] [1,2,2] [2] [2,2] [2] (3!) = (right-left)!
            [1,2,2,2] = [1,2] [1,2,2] [1,2,2,2]

        */

        long count = 0;
        int length = nums.length;
        int left = 0;
        int right = 0;
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();

        while(right < length) {
            while(left < right && (
                Math.abs(minQ.peekFirst() - nums[right]) > 2 || 
                Math.abs(maxQ.peekFirst() - nums[right]) > 2)
            ) {
                if(minQ.peekFirst() == nums[left]) {
                    minQ.removeFirst();
                }

                if(maxQ.peekFirst() == nums[left]) {
                    maxQ.removeFirst();
                }

                count += (right - left);
                left++;
            }

            while(!minQ.isEmpty() && minQ.peekLast() > nums[right]) {
                minQ.removeLast();
            }
            minQ.addLast(nums[right]);

            while(!maxQ.isEmpty() && maxQ.peekLast() < nums[right]) {
                maxQ.removeLast();
            }
            maxQ.addLast(nums[right]);
            right++;
        }

        while(left < right) {
            count += (right - left);
            left++;
        }
        
        return count;
    }
}