class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minx = m, miny = n;
        for (int[] op : ops) {
            minx = Math.min(minx, op[0]);
            miny = Math.min(miny, op[1]);
        }
        return minx * miny;
    }
}
​
