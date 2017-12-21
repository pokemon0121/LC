public class Solution {
    public int findComplement(int num) {
        int n = num;
        int digits = 0;
        while (num != 0) {
            num /= 2;
            digits++;
        }
        int mask = (Integer.MAX_VALUE >> (31 - digits));
        //System.out.println(Integer.toString(n, 2));
        return ~n & mask;
    }
}
​
