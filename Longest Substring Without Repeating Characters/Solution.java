/*Given a string, find the length of the longest substring without repeating characters. 
For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
import java.util.*;

// use map to store visited character and its index
//time:O(n^2) space:O(n) cannot be accepted
public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		System.out.println(test.lengthOfLongestSubstring("abcabcdbb"));

	}
    public int lengthOfLongestSubstring(String s) {

    	int count = 0;
    		//find substring with non duplicates

    		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
    		for(int j = 0; j<s.length();j++){
    			if(map.containsKey(s.charAt(j))){
    				int duplicate = map.get(s.charAt(j));
    				j = duplicate;
    				count = count>map.size()?count:map.size();//map.size()!!
 					map.clear();   			
    			}
    			else{
    				map.put(s.charAt(j),j);
    				//System.out.println(s.charAt(j));
    			}
    		}
    	
    	return Math.max(count,map.size());//last substring should be counted
    }
    
    public int lengthOfLongestSubstring2(String s) {
        if (s==null || s.length()==0)
            return 0;
        int N = s.length();
        int[] set = new int[256];//same idea as hash, except that key is implicit known as ASCII code
        int i=0, j=0, max = 0;
        while (j<N){
            int ch = (int) s.charAt(j);
            set[ch]++;
            if (set[ch]==2){
                while (i<=j && set[ch]==2){
                    set[(int)s.charAt(i++)]--;
                }
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
 	
 	// runtime:O(n), space,O(n)
 	 public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        HashSet<Character> set = new HashSet<Character>();
        
        int leftBound = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (leftBound < i && s.charAt(leftBound) != s.charAt(i)) {
                    set.remove(s.charAt(leftBound));
                    leftBound ++;
                }
                leftBound ++;
            } else {
                set.add(s.charAt(i));
                max = Math.max(max, i - leftBound + 1);
            }
        }
        
        return max;
    }

 }