public class Solution {
    public int islandPerimeter(int[][] grid) {
        int island = 0;
        int neighbor = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    island++;
                    if (i + 1 < r && grid[i + 1][j] == 1) {
                        neighbor++;
                    }
                    if (j + 1 < c && grid[i][j + 1] == 1) {
                        neighbor++;
                    }
                }
            }
        }
        return island * 4 - neighbor * 2;
    }
}
​
