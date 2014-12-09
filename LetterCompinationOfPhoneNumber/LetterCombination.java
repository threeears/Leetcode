// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.

// 

public class Solution {
    public List<String> letterCombinations(String digits) {
    	String[] letters = {'abc','def','ghi','jkl','mno','pqrs','tuv','wxyz'};
    	List<String> res = new LinkedList<String>();
    	StringBuilder string = new StringBuilder();
    	letterCompination(digits,0,letters,string,rec);
    	return rec;
    	
    }

    void letterCombinations(String digits, int number, String[] letters,StringBuilder string, List<String> rec){

    }
}