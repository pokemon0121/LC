public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        int ii = 0, jj = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[ii][jj] = nums[i][j];
                jj++;
                if (jj == c) {
                    jj = 0;
                    ii++;
                }
            }
        }
        return res;
    }
}
​
