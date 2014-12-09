// Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it is able to trap after raining.

// For example, 
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

// The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
//In this case, 6 units of rain water (blue section) are being trapped. 
public class Solution {
	public static void main(String[] args){
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		Solution test = new Solution();
		test.trap(A);
	}
    public int trap(int[] A) {
    	// for each coordinate, find left lagest and right largest
		int[] left_max = new int[A.length];
		int[] right_max = new int[A.length];

		for(int i = 0;i<A.length;i++){
			if(i==0) left_max[i]=0;
			else{
				if(left_max[i-1]<A[i-1]){
					left_max[i]=A[i-1];
				}
				else{
					left_max[i]=left_max[i-1];
				}
			}
		} 
		for(int i=A.length-1;i>=0;i--){
			if(i==A.length-1) right_max[i]=0;
			else{
				if(right_max[i+1]<A[i+1]){
					right_max[i]=A[i+1];
				}
				else{
					right_max[i]=right_max[i+1];
				}
			}
		} 
		int storage = 0;
		
		for(int i = 0;i<A.length;i++)
		{
			int height = Math.min(left_max[i],right_max[i]);// this is awesome! I am a idot!
			if(height>A[i]){
				height = height-A[i];
				storage+=height;
			}
		}  
		return storage;
    }

    //solution 2, from ninechapter, not explored
   public int trap2(int[] A) {
        int sum = 0;
        int max = -1;
        int maxIndex = -1;
        int prev;

        // find the highest bar
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
                maxIndex = i;
            }
        }

        // process all bars left to the highest bar
        prev = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (A[i] > prev) {
                sum += (A[i] - prev) * (maxIndex - i);
                prev = A[i];
            }
            sum -= A[i];
        }

        // process all bars right to the highest bar
        prev = 0;
        for (int i = A.length - 1; i > maxIndex; i--) {
            if (A[i] > prev) {
                sum += (A[i] - prev) * (i - maxIndex);
                prev = A[i];
            }
            sum -= A[i];
        }

        return sum;
    }
}