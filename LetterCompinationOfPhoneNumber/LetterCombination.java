// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.

// 

public class Solution {
    public List<String> letterCombinations(String digits) {
       String[] dic ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
       List<String> res = new ArrayList<String>();
       if(digits.length()==0) return res;
       return DFS(digits, dic, res,new StringBuilder(),0 );
    }
    public List<String> DFS(String digits, String[] dic, List<String> res, StringBuilder current, int level){
        if(level==digits.length()){
            res.add(current.toString());
            return res;
        }
        
        String choices = dic[Integer.parseInt(digits.charAt(level)+"")];
        for(int i = 0;i<choices.length();i++){
            current.append(choices.charAt(i));
            DFS(digits, dic, res, current, level+1);
            current.deleteCharAt(current.length()-1);
        }
        return res;
    }
}
// notice: StringBuilder operations: append(), .length(),deleteCharAt(int index)