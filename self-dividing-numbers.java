class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> r = new ArrayList<>();
        for (int x = left; x <= right; x++) {
            if (isSDN(x)) r.add(x);
        }
        return r;
    }
    
    private boolean isSDN(int x) {
        int num = x;
        while (x != 0) {
            if (x % 10 == 0 || num % (x % 10) != 0) return false;
            x /= 10;
        }
        return true;
    }
}
​
