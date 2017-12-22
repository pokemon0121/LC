class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        int odd = 0, even = 0;
        for (int f : freq) {
            if (f % 2 == 0) even++;
            else odd++;
        }
        return odd <= 1;
    }
}
​
