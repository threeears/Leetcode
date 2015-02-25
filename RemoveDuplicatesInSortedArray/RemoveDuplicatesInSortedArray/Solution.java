// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory.

// For example,
// Given input array A = [1,1,2],

// Your function should return length = 2, and A is now [1,2].

public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length<=1) return A.length;
        int end = 0;
        int pointer = 1;
        while(pointer<A.length){
            while(pointer<A.length && A[end]==A[pointer]){
                pointer ++;
            }
            if(pointer<A.length){
                A[end+1] = A[pointer];
                end++;
                pointer ++;
            }
            
        }
        return end+1;
   }
 }

    public int removeDuplicates(int[] A) {
    if (A.length == 0) return 0;
    int i = 0;
    for (int j=0; j<A.length; j++) {
        if (A[i] != A[j]) i++;
        A[i] = A[j];
    }
    return i+1;
    }
}