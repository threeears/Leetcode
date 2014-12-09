public class Solution {
    public int largestRectangleArea(int[] height) {
		int h = height.length;
    	int size=0;
    	int max = 0;
    	for(int i = 0; i < h; i ++){
    		for(int j=i; j < h; j++){
    			size = joinRectangle(height, i, j);
    			System.out.print("("+i+","+j+"):"+size+" ");
    			if(size > max) max = size;
    		}
    		System.out.println();
    	}
    	return max; 
    }
	
	public int joinRectangle(int[] height, int start, int end){
    	int min = height[start];
    	for (int i = start+1; i <=end ; i++){
    		if(min > height[i])
    			min = height[i];
    	}
    	return min*(end-start+1);
    }
}
// O(n^2), scan all the possible solutions