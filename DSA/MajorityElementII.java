// Problem: Majority Element II
// Platform: LeetCode #229
// Difficulty: Medium
// Link: https://leetcode.com/problems/majority-element-ii/
// Topic: Arrays, HashMap
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if(n==1){
            ans.add(nums[0]);
            return ans;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        for(int key : map.keySet()){
            if(map.get(key)>(n/3)){
                ans.add(key);
            }
        }
        return ans;
    }
}