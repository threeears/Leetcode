public class Solution {
    public int divide(int dividend, int divisor) {
        long p = Math.abs((long)dividend);
        long q = Math.abs((long)divisor);
        
        int ret = 0;
        while (p >= q) {
            int counter = 0;
            while (p >= (q << counter)) {
                counter++;
            }//find the largest base compared to dividend
            ret += 1 << (counter - 1);// calculate the result of the very last base
            p -= q << (counter - 1);//substract the last base from the dividend
        }
        
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return ret;
        else
            return -ret;
    }
}
//simple and clear! Good Solution, may take more time than mine.

// map + bit manipulation
public class Solution {
    public String minWindow(String S, String T) {
        int[] needToFind = new int[256];//ASCII encoding contains 256 characters
        int[] hasFound = new int[256];
        
        if(T.length()>S.length()) return "";//SPECIAL CASES DO NOT IGNORED!
        
      for(int i=0; i < T.length(); i++){
          needToFind[T.charAt(i)]++;//like a hashtable, which stores character as key and num as value
          // also transfer char into number implies.
      }
      int start = 0;
      int end = 0;
      int count = 0;
      int finish = 0;
       int final_start = 0;
      int final_end = S.length();
      int MinWindow = final_end - final_start + 1;

      for(end= 0; end < S.length(); end++){
         if( needToFind[S.charAt(end)]!= 0 ){
             hasFound[S.charAt(end)] ++;
             if(hasFound[S.charAt(end)]<=needToFind[S.charAt(end)]){
                 count ++;
                 if(count == T.length()) 
                    {finish = end; 
                    //System.out.println("finish point:" + finish );
                    }
             }
             
         }
         if( count == T.length()){//only happens when 
             while(start < S.length()-1 && (needToFind[S.charAt(start)]==0 || 
                     needToFind[S.charAt(start)]<hasFound[S.charAt(start)])){
                //shrinking the window
                  if(needToFind[S.charAt(start)]<hasFound[S.charAt(start)]){
                      hasFound[S.charAt(start)]--;
                  }
                  start ++;

                  System.out.println("Start at:"+S.charAt(start)+" need:"+needToFind[S.charAt(start)]+" has:"+hasFound[S.charAt(start)]);
              }//found the first window, whose size is from start to end
             //System.out.println("Substring: "+S.substring(start, finish+1));
             //System.out.println("Substring to end: "+S.substring(start, end+1));
              if(MinWindow > (finish - start + 1))//find the minimum
             {  System.out.println("**start:"+start+" finish"+finish + " window"+MinWindow);
                 MinWindow = finish - start + 1;
                 final_start = start;
                 final_end = finish;
                 System.out.println("** MinWindow "+MinWindow+" Check minimum:"+S.substring(final_start,final_end+1));
             }
             if(end+1<S.length() ){
                 if(S.charAt(end+1)==S.charAt(start))//next == start
                 {  
                     hasFound[S.charAt(start)]--;
                     count--;
                     start ++;
                 }
            }       
         }  //end count      
      }//end for   
     // System.out.println("start:"+start + " end:" + end);
      if(count < T.length()) return "";//SPECIAL CASE FOR NOT FOUND A SUBSTRING
      else return S.substring(final_start,final_finish+1);
    }
}