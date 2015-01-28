// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.

// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

public class Solution {
    // backtracking time O(m^n) assume m is the average length of mapping
    // this is my recursive solution
     public List<String> letterCombinations(String digits) {
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] digitArray = digits.toCharArray();
        List<String> result = new ArrayList<String>();
        return helper(digitArray, map, result,0,new ArrayList<Character>());
    }
    public List<String> helper(char[] digitArray, String[] map,List<String> result, int level,List<Character> str){
    	
        if(level==digitArray.length){
            StringBuilder temp = new StringBuilder();
            for(int i = 0;i<str.size();i++)
                temp.append(str.get(i)+"");
            result.add(temp.toString());
            return result;
        }
        String current = map[Integer.parseInt(digitArray[level]+"")];
        for(int i = 0; i<current.length();i++){
            str.add(current.charAt(i));
            helper(digitArray,map,result,level+1,str);
            str.remove(str.size()-1);
        }
        return result;
    }

// from NineChapter
       public ArrayList<String> letterCombinations2(String digits) {
        ArrayList<String> result = new ArrayList<String>();

        if (digits == null) {
            return result;
        }

        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });

        StringBuilder sb = new StringBuilder();
        helper(map, digits, sb, result);

        return result;
    }

    private void helper(Map<Character, char[]> map, String digits, 
        StringBuilder sb, ArrayList<String> result) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (char c : map.get(digits.charAt(sb.length()))) {
            sb.append(c);
            helper(map, digits, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}