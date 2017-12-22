public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // if it is there, make it negtive 
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        List<Integer> r = new ArrayList<>();
        // remaining positive ones are answers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                r.add(i + 1);
            }
        }
        return r;
    }
}
​
