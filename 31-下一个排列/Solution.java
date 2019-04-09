class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                //找到从i索引开始比nums[i-1]大的最小的元素，并返回他的索引  132
                int index = findMin(nums, i, nums[i-1]);
                //交换i-1和该元素     231
                swap(nums, i - 1, index);
                //重新排序 i索引之后的元素  213
                Arrays.sort(nums, i, nums.length);
                return;
            }
        }
        for(int i = 0; i < len / 2; i++) {
            swap(nums, i, len - i - 1);
        }
    }
    
    private void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private int findMin(int[] arr, int index, int data) {
        int min = arr[index];
        int ret = index;
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] < min && arr[i] > data) {
                min = arr[i];
                ret = i;
            }
        }
        return ret;
    }
}