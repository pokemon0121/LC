class Solution {
    public boolean detectCapitalUse(String word) {
        int cap = 0;
        for (char c : word.toCharArray())
            if ('Z' - c >= 0) cap++;
        return (cap == 0 || cap == word.length() || (cap == 1 && 'Z' - word.charAt(0) >= 0));
    }
}
​
