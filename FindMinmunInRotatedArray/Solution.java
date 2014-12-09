public class Solution {

    // one time coding in-online judge, success! Binary Search
    // not seen other solutions
    public int findMin(int[] num) {
        int size =  num.length;
       return helper(0,size-1,num);
    }
    
    public int helper(int start, int end, int[] num){
        int min = Integer.MAX_VALUE/2;
        int min2 = min;
        if(start==end) return num[start];
        if(start==end-1) return num[start]<num[end]?num[start]:num[end];
        
        int mid = start + (end-start)/2 ;
        if(num[mid]<num[mid+1]){
             min =  helper(start,mid,num);
             min2 = helper(mid+1,end,num);
            min = min<min2?min:min2;
            return min;
            
        }
        else{
            return num[mid+1];
        }
    }
}