// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...

// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.

// Note: The sequence of integers will be represented as a string.

public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		System.out.println(test.countAndSay(Integer.parseInt(args[0])));
	}
   public String countAndSay(int n) {
        if(n<=1) return Integer.toString(n);
        String str = Integer.toString(1);
        return helpcount(1,str,n);
    }
    public String helpcount(int count, String str,int n){
    	if(count==n) return str;

    	count++;
    	StringBuilder sb = new StringBuilder();
    	int i = 0;
    	while(i<str.length()){
    		Character c = str.charAt(i);
    		int num=1;
    		while(i+1<str.length() && str.charAt(i+1)==c){
    			num++;
    			i++;
    		}
    		sb.append(Integer.toString(num));
    		sb.append(c+"");
    		i++;
    	}
    	//System.out.println("count:"+count+", string:"+sb.toString()+"------------------");
    	return helpcount(count,sb.toString(),n);
    }
}