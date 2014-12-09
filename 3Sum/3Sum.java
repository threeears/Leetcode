/*Given an array S of n integers, 
 *are there elements a, b, c in S such that a + b + c = 0? 
 *Find all unique triplets in the array which gives the sum of zero.
 *Note:
 *Elements in a triplet (a,b,c) must be in non-descending order.
 * (ie, a ≤ b ≤ c)
 *The solution set must not contain duplicate triplets.
 *For example, given array S = {-1 0 1 2 -1 -4},

	    A solution set is:
	    (-1, 0, 1)
	    (-1, -1, 2)

*/
	    // no idea, at first sight naive solution


import java.util.*;
import java.util.List;
import java.util.ArrayList;

//arraylist?list?
public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		int[] num={7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		//int[] num={0,0,0};
		System.out.println(test.threeSum3(num));
	}

	// wrong answer, one element can have muptiple answers
	public List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);

        int min = 0;
        int max = num.length-1;
        int mid = 0;

        while(min+1<max ){
        		
        		if(num[min]+num[max]+num[min+1]>0){//smallest + max<0. max--
        			max--;
        			continue;
        		}
        		else if(num[min]+num[max]+num[max-1]<0){//small+largest<0, small++
        			min++;
        			continue;
        		}
        		else{// there would be an answer between min and max
        			mid = min+1;
        			while(min+1<max && mid<max){
		        		if(num[min]+num[max]+num[mid]==0)
		        			//add min mid max in list
		        		{
		        			ArrayList<Integer> temp = new ArrayList<Integer>();
		        			temp.add(num[min]);
		        			temp.add(num[mid]);
		        			temp.add(num[max]);

		        			result.add(temp);

		        			//min++;
		        			max--;
		        			continue;
		        		}
		        		mid++;
        			}// end while
        		}// end else   
        		min++;
        		max--;
    	}
        return result;
	}
	
	//O(n^3), bad complexity
	public List<List<Integer>> threeSum2(int[] num){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int min=0;
        int max=num.length-1;
        int mid=0;
        
        while(min<=num.length-3 ){
            max=num.length-1;
        	while(max-2>=min){
        		if(num[min]+num[max]+num[min+1]>0){//smallest + max<0. max--
        		}
        		else if(num[min]+num[max]+num[max-1]<0){//small+largest<0, small++
        		}
        		else{// there would be an answer between min and max
        			mid = min +1;
        			while(mid<max){
		        		if(num[min]+num[max]+num[mid]==0)
		        			//add min mid max in list
		        		{
		        			ArrayList<Integer> temp = new ArrayList<Integer>();
		        			temp.add(num[min]);
		        			temp.add(num[mid]);
		        			temp.add(num[max]);
		        			
		        			if(result.contains(temp)==false)
		        				result.add(temp);

		        			break;
		        		}
		        		mid++;
        			}// end while
        	}
        	max--;
        }
        	min++;
        } 
        
        return result;
	}


	// O(n^2), because 2sum can be accomplished in O(n), either by hashmap or two pointers
	
	public List<List<Integer>> threeSum3(int[] num){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int min=0;
        int max=num.length-1;
        int mid=0;
        
        for(;min<=num.length-3;min++){
        	int negative = -num[min];
        	max = num.length-1;
        	mid = min+1;
        	if(min!=0 && num[min]==num[min-1]){
        		continue;
        	}
     //   	while(mid<max){
     //   		if(num[mid]+num[max]>negative){
     //   			max--;
     //   		}
     //   		else if(num[mid]+num[max]<negative){
     //   			mid++;
     //   		}
     //   		else{
     //   			ArrayList<Integer> temp = new ArrayList<Integer>();
     //   			temp.add(num[min]);
     //   			temp.add(num[mid]);
     //   			temp.add(num[max]);
       			
   		// 		result.add(temp);

     //   			while (mid < max && num[mid] == num[mid + 1])
					// 	mid++;

					// while (mid < max && num[max] == num[max - 1])
					// 	max--;
     //   			mid++;
     //   		}
     //   	}
       		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        	while(mid<=max){
        		
        		if(map.containsKey(num[mid])){
        			int k  = map.get(num[mid]);
        			ArrayList<Integer> temp = new ArrayList<Integer>();
        			temp.add(num[min]);
        			temp.add(num[mid]);
        			temp.add(num[k]);
        			
    				result.add(temp);

        			while (mid < max && num[mid] == num[mid + 1])
						mid++;
 
        			mid++;
        		}
        		else{
        			map.put(negative-num[mid], mid);
        			mid++;
        		}
        	}
        	map.clear();
        }
        return result;
	}
}
// runtime limited problem lies in list.contain(), this function increases complexity a lot!! because
// we have already sort the array, why not just compare with the next element in the array
