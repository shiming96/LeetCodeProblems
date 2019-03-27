class Solution {

    //--------------------------------------------------
    // 新建一个数组，逐个比较两个数组元素并放入新数组
    //--------------------------------------------------
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[nums1.length];
        
        int i1 = 0;
        int i2 = 0;
        int j = 0;
        while(i1 < m && i2 < n) {
            if(nums1[i1] <= nums2[i2])
                nums[j++] = nums1[i1++];
            else
                nums[j++] = nums2[i2++];
        }
        while(i1 < m) 
            nums[j++] = nums1[i1++];
        while(i2 < n)
            nums[j++] = nums2[i2++];
        
        for(int k = 0; k < m + n; k++) {
            nums1[k] = nums[k];
        }
    }

    //--------------------------------------------------
    // 归并排序中的merge操作
    //--------------------------------------------------
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        while(m > 0 && n > 0) {
            if(nums1[m-1] >= nums2[n-1]) {
                nums1[m+n-1] = nums1[m-1];
                --m;
            } else {
                nums1[m+n-1] = nums2[n-1];
                --n;
            }
        }
        if( n > 0) {
            for(int i = 0; i < n; i ++) {
                nums1[i] = nums2[i];
            }
        }
    }
}