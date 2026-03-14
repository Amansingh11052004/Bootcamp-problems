class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        Integer[][] dp = new Integer[n][2 * sum + 1];
        return helper(0, 0, nums, target, dp, sum);
    }

    public int helper(int i, int currSum, int[] nums, int target, Integer[][] dp, int sum){
        if(i == nums.length){
            if(currSum == target) return 1;
            return 0;
        }
        if(dp[i][currSum + sum] != null){ // we use here currSum + sum because currSum can be negative like -3 but we can store positive value so we add sum int it which means if currSum = -3 adding sum = 5 it will be 2 which is the index 
            return dp[i][currSum + sum];
        }
        int add = helper(i + 1, currSum + nums[i], nums, target, dp, sum);
        int subtract = helper(i + 1, currSum - nums[i], nums, target, dp, sum);
        return dp[i][currSum + sum] = add + subtract;
    }
}