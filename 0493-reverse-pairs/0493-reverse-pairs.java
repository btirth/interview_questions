class Solution {
    int ans = 0;
    public int reversePairs(int[] nums) {
        /**
        [2,4,3,5,1]

        [2,4,3] [5,1]
        [2,3,4] [1,5]
    
         */
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }

    void mergeSort(int[] arr, int start, int end) {
        if(start == end) {
            return;
        }
        
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
    
    
    void merge(int[] arr, int start, int mid, int end) {
        List<Integer> temp = new ArrayList<>();
        
        int leftIdx = start;
        int rightIdx = mid + 1;
        
        for(int i=mid+1; i<=end; i++) {
            while(leftIdx <= mid && (long)arr[leftIdx] <= 2*(long)arr[i]) {
                leftIdx++;
            }

            if(leftIdx <= mid) {
                ans += (mid - leftIdx + 1);
            }
        }

        leftIdx = start;

        while(leftIdx <= mid && rightIdx <= end) {
            if(arr[leftIdx] <= arr[rightIdx]) {
                temp.add(arr[leftIdx]);
                leftIdx++;
            } else {
                temp.add(arr[rightIdx]);
                rightIdx++;
            }
        }
        
        while(leftIdx <= mid) {
            temp.add(arr[leftIdx]);
            leftIdx++;
        }
        
        while(rightIdx <= end) {
            temp.add(arr[rightIdx]);
            rightIdx++;
        }
        
        int idx = 0;
        for(int i=start; i<=end; i++) {
            arr[i] = temp.get(idx);
            idx++;
        }
    }
}