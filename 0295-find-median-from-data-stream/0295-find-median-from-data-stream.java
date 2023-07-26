class MedianFinder {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>((x,y)->y-x);
    }
    
    public void addNum(int num) {
        if (maxheap.isEmpty()) {
            maxheap.add(num);
            return;
        }

        if (num <= maxheap.peek()) {
            maxheap.add(num);
        } else {
            minheap.add(num);
        }

        // Balance the heaps
        if (maxheap.size() > minheap.size() + 1) {
            minheap.add(maxheap.poll());
        } else if (minheap.size() > maxheap.size()) {
            maxheap.add(minheap.poll());
        }
    }

    
    public double findMedian() {
        if(maxheap.size()==0)return 0;
        if(maxheap.size()>minheap.size())return maxheap.peek();
        return (maxheap.peek()+minheap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */