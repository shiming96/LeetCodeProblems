import java.util.*;
class Solution {

    //--------------------------------------------------
    // 多一重循环，变成两数之和，O(n2)  ---很容易超时
    //--------------------------------------------------
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);

        //利用set去重
        HashSet<List<Integer>> ret = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if(a > 0)
                break;
            HashSet<Integer> set = new HashSet();
            for(int j = i + 1; j < nums.length; j++) {
                int b = nums[j];

                int c = 0 - a - b;
                if(set.contains(c)) {
                    ret.add(Arrays.asList(a, b, c));
                } else {
                    set.add(b);
                }
            }
        }
        return new ArrayList<>(ret);
    }

    //--------------------------------------------------
    // 单循环，双指针逼近法  O(n2)  巧妙去重，耗时较低
    //--------------------------------------------------
    public List<List<Integer>> threeSum1(int[] nums) {
        
        Arrays.sort(nums);
        HashSet<List<Integer>> ret = new HashSet<>();

        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0)
                break;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                if(nums[i] + nums[j] + nums[k] > 0)
                    --k;
                else if(nums[i] + nums[j] + nums[k] < 0)
                    ++j;
                else {
                    ret.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    //相邻数字重复直接跳过，方便去重
                    while(j < k && nums[j] == nums[j+1])
                        ++j;
                     while(j < k && nums[k] == nums[k-1])
                        --k;
                    ++j;
                    --k;
                }
            }
        }
        return new ArrayList<>(ret);
    }

}