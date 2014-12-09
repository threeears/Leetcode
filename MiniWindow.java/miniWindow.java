public class Solution {
	// to check if a window covers a string is the KEY!
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

	    	  }//found the first window, whose size is from start to end
			 
            if(MinWindow > (finish - start + 1))//find the minimum
    	  	 {	
    	  		 MinWindow = finish - start + 1;
    	  		 final_start = start;
    	  		 final_end = finish;
    	  	 }
			 if(end+1<S.length() ){
				 if(S.charAt(end+1)==S.charAt(start))//next == start
				 {	
					 hasFound[S.charAt(start)]--;
					 count--;
					 start ++;
				 }
			}		
		 }	//end count   	 
      }//end for   
      if(count < T.length()) return "";//SPECIAL CASE FOR NOT FOUND A SUBSTRING
      else return S.substring(final_start,final_end+1);
    }
}