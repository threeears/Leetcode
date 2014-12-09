// Given a sorted array and a target value, return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.

// You may assume no duplicates in the array.

// Here are few examples.
// [1,3,5,6], 5 → 2
// [1,3,5,6], 2 → 1
// [1,3,5,6], 7 → 4
// [1,3,5,6], 0 → 0

public class Solution {
	public static void main(String[] agrs){
		int[] A={1,3};
		Solution test = new Solution();
		System.out.println(test.searchInsert(A,4));
	}
    public int searchInsert(int[] A, int target) {

    	// find the right position of given value in a sorted array
    	// binary search to find a position
    	return binarySearch(0,A.length-1,A, target);    	
        
    }
    public int binarySearch(int start, int end, int[] A, int target){

    	int result = -1;
    	if(start>=end && A[start]!=target){// only two elemets, start == mid, then mid-1 would overflow
    		result = A[start]<target?start+1:start;
    		return result;// at the end of search, stop here!!
    	}
    	int mid = start + (end-start)/2;
    	if(A[mid]==target)// apply to 1, 2...as long as target is in the array
    		result = mid;
    	else if(A[mid]<target){
    		// target is on the right of mid
    		result = binarySearch(mid+1, end, A, target);
    	}
    	else
    		result = binarySearch(start, mid-1, A,target);

    	return result;
    }

}