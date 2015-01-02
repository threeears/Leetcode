// Given an array and a value, 
//remove all instances of that value in place and return the new length.

// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A.length==0) return 0;
        Arrays.sort(A);
        int i = 0;
        int count = A.length;
        while(i<count){
             if(A[i]==elem){
                // exchange A[i] with last element;
                int temp = A[i];
                A[i]=A[count-1];
                A[count-1]=temp;
                count--;
                i--;//what if the last one also duplicates?
             }
             i++;
        }
        return count;
    }
}