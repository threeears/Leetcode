// There are N children standing in a line. Each child is assigned a rating value.

// You are giving candies to these children subjected to the following requirements:

// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
// What is the minimum candies you must give?

public class Solution {
	public static void main(String[] args){
		Solution test  = new Solution();
		int[] ratings={2,1};
		System.out.println(test.candy(ratings));
	}
    public int candy(int[] ratings) {

    	int[] candy=new int[ratings.length];
        // first round, initilize 
        for(int i = 0;i < candy.length; i++){
        	candy[i]=1;
        }
        //second round, deal with increasing rating
        for(int i = 1; i< candy.length; i++){
        	if(ratings[i]>ratings[i-1])
        		candy[i]= candy[i-1]+1;
//        	else if(ratings[i]==ratings[i-1])
//        		candy[i]= candy[i-1];
        	else{}
        }
    	//third round, deal with decreasing rating
    	for(int i = candy.length-1;i>=0; i--){
    		if(i-1>=0 && ratings[i]<ratings[i-1] && candy[i-1]<=candy[i]){
    			candy[i-1]=candy[i]+1;
    		}
//    		else if(i-1>=0 && ratings[i]==ratings[i-1] && candy[i-1]<=candy[i]){
//    			candy[i-1]=candy[i];
//    		}//do not care if it is equal
    		else{};

    	}

    	int total = 0;
       for(int i = 0;i < candy.length; i++){
       		total+=candy[i];
       }

       return total;
      }
  }