class Solution {

    //--------------------------------------------------
    // 二分查找
    //--------------------------------------------------

    public int searchInsert(int[] nums, int target) {
        if(target > nums[nums.length-1])
            return nums.length;
        if(target <= nums[0])
            return 0;
        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2;
        while(start < end - 1) {
            if(target > nums[mid]) {
                start = mid;
                mid = start + (end - start) / 2;
            } else if(target < nums[mid]) {
                end = mid;
                mid = start + (end - start) / 2;
            } else {
                return mid;
            }
        }
        return end;
        
    }

    //--------------------------------------------------
    // 线性查找
    //--------------------------------------------------
    public int searchInsert1(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++)
            if(nums[i] >= target)
                return i;
        return nums.length;
    }
}