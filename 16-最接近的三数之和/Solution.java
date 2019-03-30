class Solution {

    //--------------------------------------------------
    // 暴力法  O(n3)
    //--------------------------------------------------
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int ret = 0;
        for(int i = 0; i < len; i++) {
            for(int j = i+1 ; j < len; j++) {
                for(int k =j+1; k < len; k++) {
                    if(Math.abs(nums[i] + nums[j] + nums[k] - target) < min) {
                        min = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        ret = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return ret;
    }

    //--------------------------------------------------
    // 单循环加双指针法  O(n2)      
    //先排序    然后双指针遍历
    //--------------------------------------------------
    public int threeSumClosest1(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int min = Integer.MAX_VALUE;
        int ret = 0;
        
        for(int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int num = nums[i] + nums[j] + nums[k];
                if(Math.abs(num - target) < min) {
                    min = Math.abs(num - target);
                    ret = num;
                }
                if(num < target)
                    j++;
                else if(num > target)
                    k--;
                else
                    return target;
            }
        }
        return ret;
    }

}