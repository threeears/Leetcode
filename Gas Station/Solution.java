// There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 

//You begin the journey with an empty tank at one of the gas stations.

// Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

// Note:
// The solution is guaranteed to be unique.
import java.util.Stack;
import java.util.LinkedList;
import java.util.HashMap;

public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		int[] gas = {1,2,3,4,5};
		int[] cost={2,2,5,5,3};
		System.out.println(test.canCompleteCircuit(gas, cost));
	}
	//Greedy!! to prove!! if the furtherst destination is not the starting point, all the gas station
	// passed by cannot be the starting point 
	public int canCompleteCircuit(int[] gas, int[] cost) {  
	    int length = gas.length;  
	  
	    int start;  
	    int k = 0; // start testing from the first station  
	    while (true) {  
	        int sum = 0;  
	        start = k % length; // save the starting point  
	        do {  
	            sum += gas[k % length] - cost[k % length];  
	            k++;  
	        } while (sum >= 0 && k < start + length);  
	  
	        // complete a cycle  
	        if (k == start + length && sum >= 0) {  
	            return k - length;  
	        }  
	        // test from the end that has not been reached  
	        else {  
	            if (k >= length)  
	                return -1;  
	        }  
	    }  
	}  
}









