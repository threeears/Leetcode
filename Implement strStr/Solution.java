// Implement strStr().

// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0 ) return 0;
        else{
                int pointer = 0;
                int last = 0;
                for(int i = 0;i<haystack.length();i++){
                    if(haystack.charAt(i)==needle.charAt(pointer)){
                        if(pointer==0){
                            last = i;
                        }
                        pointer++;
                        if(pointer==needle.length())
                            return last;
                    }
                    else{
                        if(pointer!=0)
                        {
                            pointer=0;// whent back to the next possible position
                            i=last;
                        }
                    }
                }
                return -1;
         }
       
    }
}