public class Solution {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int r = 0;
        while (z > 0) {
            z = z & (z - 1);
            r++;
        }
        return r;
    }
}
​
