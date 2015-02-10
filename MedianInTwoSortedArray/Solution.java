// There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. 
// The overall run time complexity should be O(log (m+n)).


public class Solution {
    // divide and conqure solution, not implemented by me, time complexity O(log(m=n))
    public double findMedianSortedArrays(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0 ;
        } else {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
    }
    
    // find kth number of two sorted array
    public static int findKth(int[] A, int A_start, int[] B, int B_start, int k){       
        if(A_start >= A.length) 
            return B[B_start + k - 1];
        if(B_start >= B.length)
            return A[A_start + k - 1];

        if (k == 1)
            return Math.min(A[A_start], B[B_start]);
        
        int A_key = A_start + k / 2 - 1 < A.length
                    ? A[A_start + k / 2 - 1]
                    : Integer.MAX_VALUE;
        int B_key = B_start + k / 2 - 1 < B.length
                    ? B[B_start + k / 2 - 1]
                    : Integer.MAX_VALUE; 
        
        if (A_key < B_key) {
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        } else {
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }
    }


    //this is my heapify solution, takes nlogn
    public double findMedianSortedArrays(int A[], int B[]) {
        if(A.length==0 && B.length==0) return -1;
        int[] temp = new int[A.length+B.length];//maintain a MiniHeap
        for(int i = 0;i<temp.length;i++)// takes O(N)
        {   if(i<A.length)
                temp[i]=A[i];
            else
                temp[i] = B[i-A.length];
        }
        MiniHeapify(temp, temp.length);
         int size = temp.length;
        for(int i = 0;i<temp.length;i++){
            // exchange tail with head
            // takes NlogN
            int tail = temp[size-1];
            temp[size-1] = temp[0];
            temp[0] = tail;
            size--;
            MiniHeapify(temp, size);
        }
        if(temp.length%2==0)
            return (temp[temp.length/2]+temp[(temp.length-1)/2])*1.0/2;
        else
            return temp[(temp.length-1)/2];
    }
    public void MiniHeapify(int[] array,  int size){
        // root is 0, left children: 2*i+1, right children 2*i+2, index be careful
        //if does not have right child or does not have left child?
        // takes logN
        for(int i = size/2-1;i>=0;i--){
            // check backward from the first non-leaf node,
            int root = array[i];
            int temp = i;
            if((i+1)*2-1<size){// check left exist
                temp = (i+1)*2-1;
                if((i+1)*2<size)//check right exist
                    temp = array[(i+1)*2-1]>array[(i+1)*2]?(i+1)*2:((i+1)*2-1);// index of mini value of left and right
            }
            if(root>array[temp]) { // exchange root with temp
                    array[i]=array[temp];
                    array[temp]=root;
             }
           
        }
    }
    // way three merge sort
}