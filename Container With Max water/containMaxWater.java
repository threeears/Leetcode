/* n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

public class Solution {
    public int maxArea(int[] height){
		int area=0;
		for(int i=0,j=height.length-1;i<j;i++,j--){
			if(height[i]<height[j]){
				area=area<(j-i)*height[i]?(j-i)*height[i]:area;
				j++;
			}
			else{
				area=area<(j-i)*height[j]?(j-i)*height[j]:area;
				i--;
			}
		}
		return area;
	}
}
//O(n),O(1);