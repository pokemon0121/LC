class Logger {
​
    private Map<String, Integer> counter;
    
    /** Initialize your data structure here. */
    public Logger() {
        counter = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!counter.containsKey(message) || (counter.containsKey(message) && timestamp - counter.get(message) >= 10)) {
            counter.put(message, timestamp);
            return true;
        }
        else return false;
    }
}
​
/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
​
