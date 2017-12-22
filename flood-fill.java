class Solution {
    
    private int oldColor;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        oldColor = image[sr][sc];
        dfs(image, sr, sc, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int x, int y, int newColor) {
        if (newColor == oldColor || x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != oldColor) 
            return;
        image[x][y] = newColor;
        dfs(image, x + 1, y, newColor);
        dfs(image, x, y + 1, newColor);
        dfs(image, x - 1, y, newColor);
        dfs(image, x, y - 1, newColor);
    }
}
​
