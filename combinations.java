public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> cur, int index, int n, int k) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i <= n; i++) {
            // always loop through the rest
            cur.add(i);
            dfs(res, cur, i + 1, n, k);
            cur.remove(cur.size() - 1);
        }
    }
​
}
​
