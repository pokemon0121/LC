class Solution {
    public int majorityElement(int[] nums) {
        // moore voting
        int m = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                m = nums[i];
            }
            else
                count += m == nums[i] ? 1 : -1;
        }
        return m;
    }
}
​
