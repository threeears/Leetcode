/*Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;


public class TwoSum {
	public static void main(String[] arg){
		int[] a={-3,40,3,90};
		TwoSum test = new TwoSum();
		int[] tresult = test.twoSum(a,0);
		for(int temp:tresult)
         	System.out.println(temp);
	}
    public int[] twoSum(int[] numbers, int target) {

    	HashMap<Integer, Integer>map = new HashMap<Integer,Integer>();
        int[] result = new int[2];

        for(int i =0;i<numbers.length;i++){
        	if(map.containsKey(numbers[i])){
        		int index = map.get(numbers[i]);
        		result[0] = index + 1;
        		result[1] = i + 1;
        		break;
          }
          else{
          	map.put(target-numbers[i],i);
          }
        }

       return result;
    }

}

// O(n), (key, value): key is the number of value, value is the index
// other solution, use two pointers for sorted array



