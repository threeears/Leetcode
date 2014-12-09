// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.

// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

// The number of ways decoding "12" is 2.


// notice 0 has no mapping
// 10,20 has only one mapping
//record[i] all combinations starts from i, then add two kind of combinations, not only one
public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		System.out.println(test.numDecodings("10"));
	}
    public int numDecodings(String s) {
        int[]  record = new int[s.length()+1];//record[i]: from i to end, how many conbinations

        if(s.length()==0) return 0;
        
        if(s.length()==1)
        {
            if(s.charAt(0)=='0')
               return 0;
             else
                return 1;
        }


        if(s.charAt(s.length()-1)!='0'){
        	 record[s.length()-1]=1;
        }else{
        	record[s.length()-1]=0;
        }

        record[s.length()]=1;

        for(int i = s.length()-2;i >=0;i--){
        	String current = s.charAt(i)+"";
        	String after = s.charAt(i+1)+"";// parse int cannot parse char, to turn char to int, add empty string
        	if(Integer.parseInt(current)==1 ){
        		if(Integer.parseInt(after)!=0)
        			record[i] = record[i+2] + record[i+1];
        		else
        			record[i] = record[i+2];

        	}
        	else if(Integer.parseInt(current)==2 && Integer.parseInt(after)<=6){
        		if(Integer.parseInt(after)!=0)
        			record[i] = record[i+2] + record[i+1];
        		else
        			record[i] = record[i+2];

        	}
        	else if(Integer.parseInt(current)==0){// 0 only make sense when element before it is 1 or 2
        		record[i]=0;

        	}
        	else{
        		record[i] = record[i+1];        	

        	}
        }
        return record[0];
    }
}