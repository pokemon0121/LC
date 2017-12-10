class NumMatrix {
​
    // O(log(m) * log(n))
    
    private int[][] BIT;
    private int[][] nums;
    private int m, n;
    
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        BIT = new int[m + 1][n + 1];
        nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) return;
        int delta = val - nums[row][col];
        nums[row][col] = val;
        for (int i = row + 1; i <= m; i += i & (-i)) {
            for (int j = col + 1; j <= n; j += j & (-j)) {
                //System.out.println("updating (" + i + "," + j + ") with val " + val);
                BIT[i][j] += delta;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (m == 0 || n == 0) return 0;
        return sum(row2 + 1, col2 + 1) - sum(row1, col2 + 1) - sum(row2 + 1, col1) + sum(row1, col1);
    }
    
    private int sum(int x, int y) {
        //System.out.println("sum called at (" + x + "," + y + ")");
        int sum = 0;
        for (int i = x; i > 0; i -= i & (-i)) {
            for (int j = y; j > 0; j -= j & (-j)) {
                //System.out.println("getting BIT[" + i + "][" + j + "]");
                sum += BIT[i][j];
            }
        }
        return sum;
    }
}
​
/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
