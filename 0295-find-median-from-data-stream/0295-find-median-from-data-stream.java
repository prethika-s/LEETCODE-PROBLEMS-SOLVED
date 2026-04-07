class MedianFinder {
    PriorityQueue<Integer> smallHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> largeHeap = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(smallHeap.size()==largeHeap.size()){
            smallHeap.offer(num);
            int temp = smallHeap.poll();
            largeHeap.offer(temp);
        }
        else{
            largeHeap.offer(num);
            int temp = largeHeap.poll();
            smallHeap.offer(temp);
        }
    }
    
    public double findMedian() {
        int smallSize = smallHeap.size();
        int largeSize = largeHeap.size();
        int arrSize = smallSize+largeSize;
        if(arrSize%2==0){
            return (smallHeap.peek()+largeHeap.peek())/(2.0);
        }
        else{
            return largeHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */