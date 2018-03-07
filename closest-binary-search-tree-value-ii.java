/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> closestK = new ArrayList<>();
        if (root == null) return closestK;
        List<Integer> sorted = new ArrayList<>();
        toSortedArray(sorted, root); // O(n)
        // bs
        int start = 0, end = sorted.size() - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (sorted.get(mid) > target) end = mid;
            else start = mid;
        }
        // check start and end
        int closestIndex = Math.abs(sorted.get(start) - target) < Math.abs(sorted.get(end) - target) ? start : end;
        closestK.add(sorted.get(closestIndex));
        for (int i = closestIndex - 1, j = closestIndex + 1; (i >= 0 || j < sorted.size()) && k > 1; k--) {
            if (i == -1) closestK.add(sorted.get(j++));
            else if (j == sorted.size()) closestK.add(sorted.get(i--));
            else {
                if (Math.abs(sorted.get(i) - target) < Math.abs(sorted.get(j) - target))
                    closestK.add(sorted.get(i--));
                else closestK.add(sorted.get(j++));
            }
        }
        return closestK;
    }
    
    private void toSortedArray(List<Integer> sorted, TreeNode root) {
        if (root == null) return;
        toSortedArray(sorted, root.left);
        sorted.add(root.val);
        toSortedArray(sorted, root.right);
    }
}
​
