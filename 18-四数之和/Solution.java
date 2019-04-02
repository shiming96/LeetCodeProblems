class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums.length < 4 || nums[0] > 0)
            return Collections.EMPTY_LIST;
        
        HashSet<List<Integer>> set = new HashSet<>();
        
        for(int i = 0; i < nums.length - 3; i++) {
            int a = nums[i];
            for(int j = i + 1; j < nums.length - 2; j++) {
                int b = nums[j];
                int m = j + 1;
                int n = nums.length - 1;
                while(m < n) {
                    if(a + b + nums[m] + nums[n] > target) {
                        n--;
                    } else if(a + b + nums[m] + nums[n] < target) {
                        m++;
                    } else {
                        set.add(Arrays.asList(a, b, nums[m], nums[n]));
                        while(m < nums.length - 1 && nums[m] == nums[m+1])
                            m++;
                        while(n > j + 1 && nums[n] == nums[n-1])
                            n--;
                        m++;
                        n--;
                    }
                }
            }
        }
        return new ArrayList(set);
        
    }
}