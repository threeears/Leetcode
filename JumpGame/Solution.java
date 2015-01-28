// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Determine if you are able to reach the last index.

// For example:
// A = [2,3,1,1,4], return true.

// A = [3,2,1,0,4], return false.


public class Solution {
    // be careful about  the index, reachable start from ZERO
    public boolean canJump(int[] A) {
        int reachable = A[0];// keep the furtherest step we could reach now, start from 0
        if(A.length==1) return true;
        for(int i = 0;i<=reachable;i++){
            reachable = Math.max(reachable, i+A[i]);
            if(reachable>=A.length-1)
                return true;
        }
        return false;
    }
}