// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...

// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.

// Note: The sequence of integers will be represented as a string.

public class Solution {
    // my recursive solution time O(n^2)
	 public String countAndSay(int n) {
       if(n==0) return "";
       return recursiveCount(n, "1");
    }
  private String recursiveCount(int level, String str){
      if(level==1)
        return str;
      else{
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<str.length();i++){
            int j = i;
            while(j+1<str.length() && str.charAt(j)==str.charAt(j+1)){
              j++;
            }
            sb.append(Integer.toString(j-i+1));
            sb.append(str.charAt(i));
            i = j;// keep i up with j
            }
          return recursiveCount(--level, sb.toString());
      }      
  }
  // my iterative solution
   public String countAndSay(int n) {
       //iterative solution
       if(n==0) return "";
       StringBuilder res = new StringBuilder();
       res.append("1");
       while(n>1){
           StringBuilder temp = new StringBuilder();
           String current = res.toString();
           for(int i = 0; i<current.length();i++){
               int j = i;
               while(j+1<current.length() && current.charAt(j)==current.charAt(j+1)){
                   j++;
               }
               temp.append(Integer.toString(j-i+1));// Integer to String conversion
               temp.append(current.charAt(i));
               i=j;// notice the order!!
             }
        res = temp;
        n--;
     }
     return res.toString();
  }
}