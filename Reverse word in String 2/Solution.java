/*Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/

public class Solution {
	static String s = " Hello  I am   threeears  !";
	public static void main(String[] args)
	{
		Solution test = new Solution();
    	System.out.println(test.reverseWords(s));

	}
    public String reverseWords(String s) {
    	String[] words = s.split(" ");
    	//String newString = "";
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = words.length-1;i>=0;i--){
    		if(words[i].equals("")) continue;
    		//else newString += words[i] + " ";
    		else sb.append(words[i]).append(" ");
    	}    	
//    	if(newString.length()>=1)
//    		newString = newString.substring(0,newString.length()-1);
    	
        return sb.length()==0 ? "": sb.substring(0,sb.length()-1);
    }
}

//notice: when build string in a loop, it is better to use stringbuilder rather than concatinating on string objects
//because its time consuming and memeory useage intensive.