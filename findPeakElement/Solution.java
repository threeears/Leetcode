public class Solution {

	// O(n)
    public int findPeakElement(int[] num) {
        if(num.length==0) return 0;
        for(int i = 1;i<num.length;i++){
            if(num[i]<num[i-1])
                return i-1;
        }
        return num.length-1;
    }

    //log(n) just find the maximum value, no matter it is a global or local maximum

    public int findPeakElement(int[] num){
    	if(num.length==0) return 0;
    	int mid = num.length/2;
    	while(mid<length){
    		if( num[mid]>num[mid+1]){
    			returun mid+1;
    		}
    		else{
    			mid  = mid + (num.length-mid)/2+1;
    		}
    	}
    	return mid;
    	
    }
    
}
