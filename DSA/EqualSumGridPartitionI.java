// Problem: Equal Sum Grid Partition I
// Platform: LeetCode #3396
// Difficulty: Medium
// Link: https://leetcode.com/problems/equal-sum-grid-partition-i/
// Topic: Arrays, Prefix Sum
// Time Complexity: O(m*n)
// Space Complexity: O(m+n)

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long hor[] = new long[m];
        long ver[] = new long[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                hor[i]+=grid[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ver[i]+=grid[j][i];
            }
        }
        long horSum = 0;
        for(long num:hor){
            horSum+=num;
        }
        long verSum = 0;
        for(long num:ver){
            verSum+=num;
        }
        long hsum=0;
        for(long num:hor){
            hsum+=num;
            if(hsum==(horSum-hsum)) return true;
        }
        long vsum=0;
        for(long num:ver){
            vsum+=num;
            if(vsum==(verSum-vsum)) return true;
        }
        return false;
    }
}