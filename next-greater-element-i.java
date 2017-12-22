public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for (int n : nums) {
            while (!s.isEmpty() && s.peek() < n)
                map.put(s.pop(), n);
            s.push(n);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
}
​
