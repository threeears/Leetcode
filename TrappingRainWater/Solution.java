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
        if(A.length<=1) return 0;
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        // find the left_max of element i
        for(int i = 1;i<A.length;i++){
            if(A[i-1]>A[i] && left[i-1]<A[i-1]){// compare if its left maximal
                left[i]=A[i-1];
            }
            else{
                left[i]=left[i-1];
            }
        }
        // find the right_max of element i
        for(int i = A.length-2;i>=0;i--){
            if(A[i]<A[i+1] && A[i+1]>right[i+1]){// compare if it's right maximal 
                right[i]=A[i+1];
            }
            else {
                right[i]=right[i+1];
            }
        }
        // add area by unit height
        int area=0;
        for(int i=1;i<A.length-1;i++){
            int height=Math.min(left[i],right[i]);
            if(height>A[i])
                area+=(height-A[i]);// calculate by unit, do not need length 
        }
        return area;
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

    // from taoge, sum of all cantainers with left as critical edge + with right critical edge = all.
    // time O(n), space O(1)
    public int trap(int[] A) {
        if(A == null || A.length == 0) return 0;
        int left = 0;
        while(left < A.length && A[left] == 0) left++;  // skip zeros
        int current = left + 1, tmp = 0, sum = 0;
        while(current < A.length) { // from left to right
            if(A[current] >= A[left]) {
                sum += tmp; // add temp
                tmp = 0;    // reset
                left = current; // move left
            }
            else tmp += A[left] - A[current];
            current++;
        }
        int right = A.length - 1;
        while(right >= left && A[right] == 0) right--;  // skip zeros
        current = right - 1; tmp = 0;
        while(current >= left) { // from right to left
            if(A[current] >= A[right]) {
                sum += tmp; // add temp
                tmp = 0;    // reset
                right = current;    // move right
            }
            else tmp += A[right] - A[current];
            current--;
        }
        return sum;
    }
}