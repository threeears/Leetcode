// Validate if a given string is numeric.

// Some examples:
// "0" => true
// " 0.1 " => true
// "abc" => false
// "1 a" => false
// "2e10" => true
// Note: It is intended for the problem statement to be ambiguous. 
//You should gather all requirements up front before implementing one.


public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		test.isNumber(".0001");
	}

	// good and convenient! solution
    public boolean isNumber(String s) {
      s = s.trim();
      if (s.length() == 0 || s.equals("e")  || s.equals(".")) return false;
      return isFloating(s) || isRegular(s);
   }

   // parses non-floating point literals
   private boolean isRegular(String s) {
      return (s.matches("[+-]?[0-9]+[.]?[0-9]*") || s.matches("[+-]?[0-9]*[.]?[0-9]+"));
   }

    // parses floating point literals as defined here: http://en.cppreference.com/w/cpp/language/floating_literal
   private boolean isFloating(String s) {
      //first one enforces an number after ., the second one enforces a number before .
      // we want to make sure there's at least one number present.
      return (s.matches("[+-]?[0-9]*[.]?[0-9]+[eE][-+]?[0-9]+[f]?") || s.matches("[+-]?[0-9]+[.]?[0-9]*[eE][-+]?[0-9]+[f]?"));
   }
}