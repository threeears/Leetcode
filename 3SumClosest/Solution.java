// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
// Return the sum of the three integers. You may assume that each input would have exactly one solution.

//     For example, given array S = {-1 2 1 -4}, and target = 1.
// -4,-1,1,2
//    6, 4, 3
//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

public class Solution {
    public int threeSumClosest(int[] num, int target) {

    	Arrays.sort(num);
    	int closestSum = num.length()-1;// maximize the difference


    	for(int i = 0;i<num.length;i++){
    		int negative = -target + num[i];
    		for(int j = i;j<num.length.j++){

    			ArrayList<Integer> sub = new ArrayList<Integer>();
    			if(sub.contains(num[j]))
    				return target; //exact match
    			else{
    				sub.add(negative-num[j]);// near closest pair: num[i], num[j], target-num[i]-num[j]
	    			for(int k=j+1;k<num.length();k++){
	    				int diff = num[k]-sub.get(sub.length()-1);
	    				closestSum = diff<closestSum?diff:closestSum;
	    			}	
    			}
    			//array sub is sorted decreasingly

    		}
    	}

        return closestSum;
    }
}