public class Solution {
    public int lengthLongestPath(String input) {
        // change something
        String[] paths = input.split("\n");
        int[] depth = new int[paths.length + 1];
        int maxLen = 0;
        for (String s : paths) {
            int level = s.lastIndexOf("\t") + 1;
            depth[level + 1] = depth[level] + s.length() - level + 1;
            int curLen = depth[level + 1];
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, curLen - 1);
            }
        }
        return maxLen;
    }
}
​
