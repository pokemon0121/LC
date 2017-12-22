public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, maxSoFar = 0;
        for (int num : nums) {
           max = Math.max(max, maxSoFar = num == 0 ? 0 : maxSoFar + 1);
        }
        return max;
    }
}
​
