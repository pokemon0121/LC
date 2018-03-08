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
    // O(n) to sorted list, O(logn) binary search, O(k) find k closest
    /*
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
    */
    // O(logn) + O(klogn)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> closestK = new ArrayList<>();
        if (root == null) return closestK;
        TreeNode closest = root, cur = root;
        while (cur != null) {
            if (cur.val == target) {
                closest = cur;
                break;
            }
            if (Math.abs(cur.val - target) < Math.abs(closest.val - target))
                closest = cur;
            cur = target > cur.val ? cur.right : cur.left;
        }
        TreeNode pre = inorderPredecessor(root, closest);
        TreeNode succ = inorderSuccessor(root, closest);
        closestK.add(closest.val);
        while ((pre != null || succ != null) && k-- > 1) {
            if (pre == null) {
                closestK.add(succ.val);
                succ = inorderSuccessor(root, succ);
            }
            else if (succ == null) {
                closestK.add(pre.val);
                pre = inorderPredecessor(root, pre);
            }
            else {
                if (Math.abs(pre.val - target) < Math.abs(succ.val - target)) {
                    closestK.add(pre.val);
                    pre = inorderPredecessor(root, pre);
                }
                else {
                    closestK.add(succ.val);
                    succ = inorderSuccessor(root, succ);
                }
            }
        }
        return closestK;
    }
    
    private TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (root.val > p.val) {
                succ = root;
                root = root.left;
            }
            else root = root.right;
        }
        return succ;
    }
    
    private TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        while (root != null) {
            if (root.val < p.val) {
                pre = root;
                root = root.right;
            }
            else root = root.left;
        }
        return pre;
    }
}
​
