public class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            k += nums[i] - min;
        }
        return k;
    }
}
​
