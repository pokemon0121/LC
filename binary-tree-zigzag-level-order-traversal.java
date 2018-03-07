/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = false;
        // left -> right: offerLast, pollFirst
        // right -> left: offerFirst, pollLast
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    TreeNode cur = q.pollLast();
                    level.add(cur.val);
                    if (cur.right != null) q.offerFirst(cur.right);
                    if (cur.left != null) q.offerFirst(cur.left);
                }
                else {
                    TreeNode cur = q.pollFirst();
                    level.add(cur.val);
                    if (cur.left != null) q.offerLast(cur.left);
                    if (cur.right != null) q.offerLast(cur.right);
                }
            }
            leftToRight = !leftToRight;
            res.add(level);
        }
        return res;
    }
​
}
​
