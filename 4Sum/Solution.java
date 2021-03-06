// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
// Return the sum of the three integers. You may assume that each input would have exactly one solution.

//     For example, given array S = {-1 2 1 -4}, and target = 1.
// -4,-1,1,2
//    6, 4, 3
//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
import java.util.*;

public class Solution {
	// sorted array, compare sum of two, use two pointer is better!
	public static void main(String[] args){
		Solution test = new Solution();
		int[] num = {-1,0,-5,-2,-2,-4,0,1,-2};
		int target = -9;//		int[] num = {43,75,-90,47,-49,72,17,-31,-68,-22,-21,-30,65,88,-75,23,97,-61,53,87,-3,33,20,51,-79,43,80,-9,34,-89,-7,93,43,55,-94,29,-32,-49,25,72,-6,35,53,63,6,-62,-96,-83,-73,66,-11,96,-90,-27,78,-51,79,35,-63,85,-82,-15,100,-82,1,-4,-41,-21,11,12,12,72,-82,-22,37,47,-18,61,60,55,22,-6,26,-60,-42,-92,68,45,-1,-26,5,-56,-1,73,92,-55,-20,-43,-56,-15,7,52,35,-90,63,41,-55,-58,46,-84,-92,17,-66,-23,96,-19,-44,77,67,-47,-48,99,51,-25,19,0,-13,-88,-10,-67,14,7,89,-69,-83,86,-70,-66,-38,-50,66,0,-67,-91,-65,83,42,70,-6,52,-21,-86,-87,-44,8,49,-76,86,-3,87,-32,81,-58,37,-55,19,-26,66,-89,-70,-69,37,0,19,-65,38,7,3,1,-96,96,-65,-52,66,5,-3,-87,-16,-96,57,-74,91,46,-79,0,-69,55,49,-96,80,83,73,56,22,58,-44,-40,-45,95,99,-97,-22,-33,-92,-51,62,20,70,90};
//		int target = 284;
		System.out.println(test.fourSum(num, target));

	}
	
	// two solution, one is extension of 3sum, takes O(n^3)
	// the other is extension of 2sum, get all pairs of 2sum and hashtable compare not checked yet!
    public List<List<Integer>> fourSum(int[] num, int target) {

    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        
        for(int i = 0;i<num.length-3;i++)
        {
        	if(i!=0 && num[i]==num[i-1] )
        		continue;
        	for(int j = i+1; j<num.length-2; j++){
        		if(num[j]==num[j-1] && j!=i+1)
        			continue;
        		int left = j+1, right =  num.length-1;
        		while(left<right && left>j && right >j){
        			int negative = target - num[i]-num[j];
        			if(num[left] + num[right]>negative){
        				right --;
					}
					else if (num[left] + num[right]<negative){
						left ++;
					}
					else{
						List<Integer> list = new ArrayList<Integer>();
						list.add(num[i]);
						list.add(num[j]);
						list.add(num[left]);
						list.add(num[right]);
						result.add(list);
						while(left+1 < right && num[left+1]==num[left]){
							left++;
						}
						while(right-1>left && num[right-1]==num[right]){
							right--;
						}
						left ++;
						right --;
					}
        		}
        	}
        }
        return result;
    }
}