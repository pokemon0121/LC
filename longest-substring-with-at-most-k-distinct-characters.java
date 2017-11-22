class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] seen = new int[256];
        int start = 0, end = 0, res = 0, count = 0;
        char[] str = s.toCharArray();
        while (end < str.length) {
            if (seen[str[end]]++ == 0) {
                count++;
            }
            if (count > k) {
                while (--seen[str[start++]] > 0);
                count--;
            }
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }
}
