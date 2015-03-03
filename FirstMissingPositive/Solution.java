// Given an unsorted integer array, find the first missing positive integer.

// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.

// Your algorithm should run in O(n) time and uses constant space.

public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A.length==0) return 1;
        
        for(int i = 0;i<A.length;i++){
            while(A[i]>0 && A[i]<=A.length && A[i]!=i+1){// condition is tricky, 
                // exchange A[A[i]-1] with A[i]
               // System.out.println(A[i]+","+A[A[i]-1]+"-------");
                int tmpIndex = A[i]-1;

            	if (A[tmpIndex] == A[i]) {//what if duplicate?
                    break;
                }
                int temp = A[i];
                A[i]=A[tmpIndex];
                A[tmpIndex] = temp;
              //  System.out.println(A[i]+","+A[tmpIndex]);
            }
        }

        for(int i = 0;i<A.length;i++){
        	if(A[i]!=i+1)
        		return i+1;//A[length-1] at length
        }
        return A.length+1;// all elements in the group are sorted, it must be the after group
    }
    // my second round solution with counting sort idea, space O(n), time O(n)
    public int firstMissingPositive(int[] A) {
        int[] count = new int[A.length+1];
        if(A.length==0) return 1;
        for(int i = 0;i<A.length;i++){
            if(A[i]<count.length && A[i]>=0)// notice the A[i]>0
                count[A[i]]=A[i];
        }
        int i=0;
        for(i = 1;i<count.length;i++){
            if(count[i]!=i)
                return i;
        }
        return count.length;
    }
    // TaoGe's bitwise solution, BetSet is an array of Bits, space more space than mine,
    public int firstMissingPositive(int[] A){
        int length = A.length >> 3 +1;// divid by 8...why? turn a byte into what??
        BitSet s = new BitSet(length);
        for(int a: A){
            if(a > 0 && a<= length )
                s.set(a);
        }
        return s.nextClearBit(1);
        // nextClearBit(int fromIndex)
//Returns the index of the first bit that is set to false that occurs on or after the specified starting index.
}
}


