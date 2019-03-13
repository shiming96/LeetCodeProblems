import java.util.HashMap;
class Solution {
    
    //--------------------------------------------------
    //                  O(n2)解法 太差    
    //--------------------------------------------------
    public int[] twoSum(int[] nums, int target) {
        
        int[] ret = new int[]{0, 0};
        
        for(int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                if(a + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return ret;
    }

    //--------------------------------------------------
    //                  O(n)解法 利用HashMap    
    //--------------------------------------------------
    public int[] twoSum1(int[] nums, int target) {
        int[] ret = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        
        for(int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if(map.containsKey(num) && map.get(num) != i) {
                ret[0] = i;
                ret[1] = map.get(num);
                break;
            }
        }
        return ret;
    }

}