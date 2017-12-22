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
    public String tree2str(TreeNode t) {
        String r = "";
        if (t == null) return r;
        r += t.val;
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (left == "" && right == "") return r;
        if (left == "") return r + "()(" + right + ")";
        if (right == "") return r + "(" + left + ")";
        return r + "(" + left + ")(" + right + ")";
    }
}
​
