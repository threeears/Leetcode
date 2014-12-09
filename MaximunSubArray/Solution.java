// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

// For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
// the contiguous subarray [4,−1,2,1] has the largest sum = 6.

// click to show more practice.

// More practice:
// If you have figured out the O(n) solution, 
//try coding another solution using the divide and conquer approach, which is more subtle.


public class Solution {

	public static void main(String[] args){
		Solution test = new Solution();
		int[] A={-2,1,8,7,-6,4,9,-9,-5,0,5,-2,5,9,7};
		System.out.println(test.maxSubArray(A));
		System.out.println(test.maxSubArray2(A));

	}

// O(n) DP

    public int maxSubArray2(int[] A) {
        // record[i]: maximun sum from i to last = add i or do not add i
        // add i: =A[i] + record[i+1]
        // do not add i = record[i+1]
        // compare the two senarios

        int[] record = new int[A.length+1];
        int maxSum = A[0];// prone to make mistake!! if only one element, return the one

        record[A.length-1]=A[A.length-1];// sum of single element is the value of the element
        record[A.length] = 0;
        for(int i = A.length-1;i>=0;i--){
        	int case_1 = record[i+1] + A[i];
        	int case_2 = A[i];

        	record[i] = Math.max(case_1,case_2);
        	if(record[i]>maxSum){
        		maxSum = record[i];
        	}
		}

		return maxSum;
    }

// Divide and Conqure
// my version, not optimized! O(nlgn) maybe? 
// fatal mistake!! I am using greedy, local maximization is not necessarily the overall maximzation
// for example: 23,-9,-5,24, the maximun value of lattern two are 24, broke the line at -5, however, the maximun
// is to add all of them together!!
// therefore, we have to find the maxsum including the mid, the compare with MAX_LEFT and MAX_RIGHT
    public int maxSubArray(int[] A) {
         if (A==null || A.length==0) return 0;

    	return FindmaxSubArray(A, 0 , A.length-1);
    }
   
public int FindmaxSubArray(int[] A, int left, int right) {
  		 if(left>right){// have to use left and right to represent
        		return -2147483648;
        }

        if(right-left==1)
        {
        	int temp = Math.max(A[left],A[right]);
        	return Math.max(temp,A[left]+A[right]);
        }
        	int mid = findMinimun(A,left,right);
        	System.out.println("midNO>:" +mid+" mid Value:"+A[mid]);
            int max_left = Integer.MIN_VALUE;
            int max_right = Integer.MIN_VALUE;
        	int sum_left =0;
        	int sum_right = 0;
        	boolean flag_left=false;
        	boolean flag_right=false;
        	
        	System.out.println("(***************************************************);");
        	        	 max_left = FindmaxSubArray(A,left,mid-1);
        	        	 System.out.println("maxleft  "+max_left);
                    	 max_right = FindmaxSubArray(A,mid+1,right);
                    	 System.out.println("maxright  "+max_right);
        
        
        	
        for(int i = mid-1; i>=left;i--){// big condition is left>=mid-1
        		sum_left += A[i];
        		if(sum_left==max_left)
        			{
        				flag_left = true;
        				break;
        			}
        	}

        	for(int i = mid+1; i<=right;i++){//big conditionis right >= mid+1
        		sum_right += A[i];
        		if(sum_right==max_right)
        			{
        				flag_right = true;
        				break;
        			}
        	}
        	

        if(left>mid-1) {flag_left=false;}
        if(right<mid+1) {flag_right=false;}
        
            int total;
        	if(flag_left==true && flag_right == true)
        		total = A[mid] + max_left + max_right;
        	else if(flag_left == true && flag_right==false)
        		total = A[mid] + max_left;
        	else if(flag_left == false && flag_right==true)
        		total = A[mid] + max_right;
        	else
        		total = -2147483648;
        		
        	int temp_max = Math.max(Math.max(max_left, max_right),A[mid]);
        	return Math.max(total, temp_max);
    }
    
    int findMinimun(int[] A, int left, int right){ // takes also takes O(n)
    	int mValue=A[left];
    	 int mIndex=left;
    	for(int i=left;i<=right;i++)
    	{
    		if(mValue > A[i]){
    			mValue = A[i];
    			mIndex = i;
    		}
    	}


    	return mIndex;
    }
    // simple version of divide and conqure O(nlgn) Good Algorithm for check maximun continuous sum!!!
    // Brilliant!!
// public int maxSubArray(int[] A) {
//         if (A==null || A.length==0) return 0;
//         return finder(A, 0, A.length-1);
//     }
    
//     public int finder(int[] A, int start, int end){
//         if (start > end)    return Integer.MIN_VALUE;
//         int mid = start + ((end - start)>>1);           // notice here, cannot omit the out-nested brackets
//         int left=Integer.MIN_VALUE, right=Integer.MIN_VALUE, sum=0;
//         for (int i=mid+1; i<=end; i++){
//             sum += A[i];
//             right = Math.max(sum,right);
//         }
//         sum = 0;
//         for (int i=mid-1; i>=start; i--){
//             sum += A[i];
//             left = Math.max(sum, left);
//         }
//         int mmax = A[mid] + Math.max(left, 0) + Math.max(right, 0);
//         return Math.max(mmax, Math.max(finder(A, start, mid-1), finder(A, mid+1, end)));
//     }
}