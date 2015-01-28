// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return all possible palindrome partitioning of s.

// For example, given s = "aab",
// Return

//   [
//     ["aa","b"],
//     ["a","a","b"]
//   ]

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> sets= new ArrayList<List<String>>();
        List<String> tmp = new ArrayList<String>();
        return helper(0,s,tmp,sets);
    }
    public List<List<String>> helper(int start,String s, List<String> tmp,List<List<String>> sets){
        if(start==s.length()){
            // if can be divided into palindromes
            List<String> new_set = new ArrayList<String>(tmp);
            sets.add(new_set);
            return sets;
        }
        
        for(int i = start;i<s.length();i++){
            if(isPalindrom(start,i,s)==true){
                tmp.add(s.substring(start,i+1));
                helper(i+1,s,tmp,sets);
                tmp.remove(tmp.size()-1);
            }
        }
        return sets;
    }
    
    // public boolean isPalindrom(int start, int end, String s){
    //     if(start==end) return true;
    //     if(start+1==end) return s.charAt(start)==s.charAt(end)?true:false;
    //     return isPalindrom(start+1,end-1,s);
    // }
    private boolean isPalindrom(int start, int end, String s) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}