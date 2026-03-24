// Problem: Construct Product Matrix
// Platform: LeetCode #2906
// Difficulty: Medium
// Link: https://leetcode.com/problems/construct-product-matrix/
// Topic: Arrays, Matrix, Prefix Product
// Time Complexity: O(n*m)
// Space Complexity: O(n*m)

class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int mod = 12345;

        int[][] ans = new int[m][n];

        long prefix = 1;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans[i][j] = (int)prefix;
                prefix = (prefix * grid[i][j]) % mod;
            }
        }

        long suffix = 1;

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                ans[i][j] = (int)((ans[i][j] * suffix) % mod);
                suffix = (suffix * grid[i][j]) % mod;
            }
        }

        return ans;
    }
}