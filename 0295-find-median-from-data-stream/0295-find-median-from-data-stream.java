class MedianFinder {

    /**
    [2,3,4,5,6,7]

    pq1 = [2] //max heap
    pq2 = [3] // min heap
    
    if pq1.size == pq2.size
        if num >= pq2.top
            pq1.add(pq2.top)
            pq2.add(num)
        else 
            pq1.add(num)

    if pq2.size > pq1.size
        if num > pq2.top
            pq1.add(pq2.top)
            pq2.add(num)
        else
            pq1.add(num)

    if pq1.size > pq2.size
        if num >= pq1.top
            pq2.add(num)
        else
            pq2.add(pq1.top)
            pq1.add(num)
     */     


    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == minHeap.size()) {
            if(maxHeap.isEmpty() || num <= minHeap.peek()) {
                maxHeap.add(num);
            } else {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
           
        } else if(maxHeap.size() < minHeap.size()) {
            if(num > minHeap.peek()) {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        } else {
            if(num >= maxHeap.peek()) {
                minHeap.add(num);
            } else {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            return (1.0 * (maxHeap.peek() + minHeap.peek())) / 2;
        } 

        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */