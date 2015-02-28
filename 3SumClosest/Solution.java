// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
// Return the sum of the three integers. You may assume that each input would have exactly one solution.

//     For example, given array S = {-1 2 1 -4}, and target = 1.
// -4,-1,1,2
//    6, 4, 3
//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

public class Solution {
    public int threeSumClosest(int[] num, int target) {

    	public int threeSumClosest(int[] num, int target) {
        if (num == null || num.length <= 2)
            return 0;
        Arrays.sort(num); // Sort to avoid duplicates and keep ascending order
        
        int gap = num[0]+num[1]+num[2];
        for (int i = 0; i < num.length-2; i++){
            int first = num[i];
            int j = i+1, k = num.length-1;
            while (j < k){
                int sum = first + num[j] + num[k];
                if (sum == target){
                    return target;
                }
                else if (sum > target)  k--;
                else j++;
                gap = Math.abs(gap-target)<Math.abs(sum-target)?gap:sum;
            }
        }
        return gap;
    }
    // O(n^2), O(1)
}