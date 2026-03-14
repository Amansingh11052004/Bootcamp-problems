class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;
        Boolean[][] dp = new Boolean[n][target + 1];
        return helper(0, nums, target, dp);
    }

    public boolean helper(int i, int[] nums, int target, Boolean[][] dp){
        if(target == 0) return true;
        if(i >= nums.length) return false; 
        if(dp[i][target] != null) return dp[i][target];
        
        boolean pick = false;
        if(nums[i] <= target){
            pick = helper(i + 1, nums, target - nums[i], dp);
        }
        boolean notPick = helper(i + 1, nums, target, dp);
        return dp[i][target] = pick || notPick;
    }
}