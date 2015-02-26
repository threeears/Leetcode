/* n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

public class Solution {
    public int maxArea(int[] height){
    	// move the smaller pointer
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

// my solution O(n), O(1), but not concise enough
	public int maxArea(int[] height){
	    int start = 0;
	    int end = height.length-1;
	    int area = Math.min(height[start], height[end])*end;
	    boolean flag = true;
	    
	    while(start<end){
	        flag = false;
	        if(height[start]<=height[start+1] && start+1!=end){
	            start++;
	            int lowBar = Math.min(height[start], height[end]);
	            area = Math.max(area, lowBar*(end-start));
	            flag = true;
	        }

	        if(end-1!=start && height[end-1]>=height[end]){
	            end--;
	            int lowBar = Math.min(height[end],height[start]);
	            area = Math.max(area, lowBar*(end-start));
	            flag = true;
	        }
	        if(flag==false){
	        	// key point here, if facing downside, keep the larger one, move the smaller one
	            int min = height[start]>height[end]?end:start;
	            if(min==end)
	                end--;
	            else
	                start++;
	        }

	    }
	    return area;
	}
}
//O(n),O(1);