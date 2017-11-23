class MovingAverage {
​
    private int k;
    private LinkedList<Integer> list;
    private double sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        k = size;
        list = new LinkedList<>();
        sum = 0;
    }
    
    public double next(int val) {
        if (list.size() >= k) sum -= list.pollFirst();
        sum += val;
        list.addLast(val);
        return sum / list.size();
    }
}
​
/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
