class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /**
        [1,0,-1,0,-2,2] target = 0
        we need to find a,b,c,d such that nums[a] + nums[b] + nums[c] + nums[d] = target

        Can we use binarySearch + 2 pointers ?

        Sort the array -> [-2,-1,0,0,1,2]
        two pointer: -2 + 2 = 0 
        -> Now out questions is target = 0 and find [-1,0,0,1]
        
        
         */

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int a = 0;

        while(a < n-3) {
            while(a > 0 && nums[a] == nums[a-1]) {
                a++;
            }

            int b = a + 1;
            while(b < n-2) {
                while(b > a+1 && nums[b] == nums[b-1]) {
                    b++;
                }

                int c = b + 1;
                int d = n - 1;

                while(c < d) {
                    long sum = (long)nums[a] + (long)nums[b] + (long)nums[c] + (long)nums[d];
                    
                    if(sum == target) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(nums[a]);
                        pair.add(nums[b]);
                        pair.add(nums[c]);
                        pair.add(nums[d]);
                        ans.add(pair);
                        
                        c++;
                        while(c<d && nums[c] == nums[c-1]) {
                            c++;
                        }

                        d--;
                        while(c<d && nums[d] == nums[d+1]) {
                            d--;
                        }
                    } else if(target > sum) {
                        c++;

                        while(c<d && nums[c] == nums[c-1]) {
                            c++;
                        }
                    } else {
                        d--;

                        while(c<d && nums[d] == nums[d+1]) {
                            d--;
                        }
                    }
                }

                b++;
                while(b<n-2 && nums[b] == nums[b-1]) {
                    b++;
                }
            }

            a++;
            while(a<n-3 && nums[a] == nums[a-1]) {
                a++;
            }
        }

        return ans;
    }
}