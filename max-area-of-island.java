class Solution {
    
    private int max = 0;
    private int cur = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    cur = 0;
                    dfs(grid, i, j);
                }
            }
        }
        return max;
    }
    
    private void dfs(int[][] g, int x, int y) {
        if (x >= g.length || x < 0 || y >= g[0].length || y < 0 || g[x][y] == 0) return;
        g[x][y] = 0;
        max = Math.max(max, ++cur);
        dfs(g, x + 1, y);
        dfs(g, x, y + 1);
        dfs(g, x - 1, y);
        dfs(g, x, y - 1);
    }
}
​
