class Solution {

    //--------------------------------------------------
    // 暴力法   O(n2)
    //--------------------------------------------------
    public int maxArea(int[] height) {
        int max = 0;
        int len = height.length;
        
        for(int i = 0; i < len; i++) {
            for(int j = len - 1; j > i; j--) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if(area > max)
                    max = area;
            }
        }
        return max;
    }

    //--------------------------------------------------
    // 双指针法   O(n)
    //--------------------------------------------------

    public int maxArea1(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while(i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if(area > max)
                max = area;
            if(height[i] <= height[j])
                ++i;
            else if(height[j] < height[i])
                --j;
            else
                break;
        }
        return max;
        
    }
}