class Solution {
    public int maxSubArray(int[] nums) {
        int realMax = nums[0];
        int curMax = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(curMax > 0) {
                curMax += nums[i];
            } else {
                curMax = nums[i];
            }
            if(curMax > realMax)
                realMax = curMax;
        }
        return realMax;
    }
}