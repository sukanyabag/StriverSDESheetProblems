/*
 * Given n non-negative integers representing an elevation map where the width of each
 * bar is 1, compute how much water it can trap after raining.
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 * Explanation: The above elevation map (black section) is represented by array [0,1,0
 * 2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being
 * trapped.
 */

package Day07;

public class TrappingRainwater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft)
                    maxLeft = height[left];
                else
                    res += maxLeft - height[left];
                    
                left++;
            }
            else {
                if (height[right] >= maxRight)
                    maxRight = height[right];
                else
                    res += maxRight - height[right];
                    
                right--;
            }
        }
        
        return res;
    }
}
