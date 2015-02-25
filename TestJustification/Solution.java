// Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

// You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

// Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

// For the last line of text, it should be left justified and no extra space is inserted between words.

// For example,
// words: ["This", "is", "an", "example", "of", "text", "justification."]
// L: 16.

// Return the formatted lines as:
// [
//    "This    is    an",
//    "example  of text",
//    "justification.  "
// ]



import java.util.ArrayList;
import java.util.List;

// text justification
public class Solution {
    public static void main(String[] args){
        Solution test = new Solution();
        String[] str = {"so","fine","That","all","the","world","will","be","in","love","with","night","And","pay","no","worship","to","the","garish","sun."};//edge cases empty string with L=0
        
        System.out.println(test.fullJustify(str,25));
    }

    // my solution, too long and not concise and not clever enough! but takes O(n) time
    public List<String> fullJustify(String[] words, int L) {
        int currentLength = 0;
        List<String> res = new ArrayList<String>();
        List<String> sub = new ArrayList<String>();
        int i = 0;
        for( i = 0;i<words.length;i++){
           // if(words[i].length()==0) continue;// edge cases [" "]
            int humanstop;
            if(words[i]=="so")
                humanstop = 1;
            if(words[i].length() + 1 + currentLength<L){
                currentLength +=words[i].length() + 1;
                sub.add(words[i]);
                if(i==words.length-1)
                { res.add(justify(sub,0,true,L));
                  sub = new ArrayList();
                  currentLength = 0;
                }
                continue;
            }
            else if (words[i].length() + currentLength + 1 ==L){
                // find a perfect match
                sub.add(words[i]);
                res.add(justify(sub, 1,false,L));
                sub = new ArrayList<String>();
                currentLength = 0;
            }
            else if(words[i].length() + currentLength == L){
                sub.add(words[i]);
                res.add(justify(sub,0,false,L));
                sub = new ArrayList<String>();
                currentLength = 0;
            }
            else{
                int diff = L+1-currentLength;
                currentLength = words[i].length()+1;
                res.add(justify(sub,diff,false,L));
                sub = new ArrayList<String>();
                sub.add(words[i]);

            }     
        }
        if(i == words.length && sub.size()>0)
            res.add(justify(sub,0,true,L));
            
        return res;
    }
    
    private String justify(List<String> str, int spaces, boolean flag,int L){
        StringBuilder[] s = new StringBuilder[str.size()];
        if(flag==true || str.size()==1){// edge cases, str.size()==1 then no need to divide
            StringBuilder last = new StringBuilder();
            int i = 0;// length of str
            int j = 0;// number of str
            while(i<L){
                if(j<str.size()-1){
                    last.append(str.get(j));
                    last.append(" ");
                    i = i+str.get(j).length()+1;
                    j++;
                    }
                else if(j==str.size()-1){
                    last.append(str.get(j));
                    if(str.get(j).length()==0)
                        {
                            L++;
                            i++;
                        }
                    else{
                        i += str.get(j).length();
                    }
                    j++;
                }
                else{
                    last.append(" ");
                    i++;
                }
 
            }
            return last.toString();

        }
        for(int i = 0;i<s.length;i++){
            s[i] = new StringBuilder();
        }
        while(spaces>0){
            for(int i = 0; i<str.size();i++){
                double k = Math.ceil(spaces*1.0/(str.size()-1-i));
                int j = (int)k;
                while(spaces>0 && j>0)
                {
                     s[i].append(' ');
                     j--;
                     spaces--;
                }
                if(spaces<=0) break;
            }
        }
       for(int i = 0;i<str.size();i++){
           if(i!=str.size()-1){
               s[str.size()-1].append(str.get(i));
               s[str.size()-1].append(s[i]);
               s[str.size()-1].append(' ');
           }
           else{
               s[str.size()-1].append(str.get(i));
           }
       }
        return s[str.size()-1].toString();
    }

    // from nineChapter, much less
      public ArrayList<String> fullJustify2(String[] words, int L) {
        int wordsCount = words.length;
        ArrayList<String> result = new ArrayList<String>();
        int curLen = 0;
        int lastI = 0;// pointer to last index
        for (int i = 0; i <= wordsCount; i++) {
            if (i == wordsCount || curLen + words[i].length() + i - lastI > L) {
                // last word or current line with spaces larger than L (i-lastI is the number of spaces need add)
                StringBuffer buf = new StringBuffer();
                int spaceCount = L - curLen;
                int spaceSlots = i - lastI - 1;
                if (spaceSlots == 0 || i == wordsCount) {
                    for(int j = lastI; j < i; j++){
                        buf.append(words[j]);
                        if(j != i - 1)
                            appendSpace(buf, 1);
                    }
                    appendSpace(buf, L - buf.length());
                } else {
                    int spaceEach = spaceCount / spaceSlots;
                    int spaceExtra = spaceCount % spaceSlots;
                    for (int j = lastI; j < i; j++) {
                        buf.append(words[j]);
                        if (j != i - 1)
                            appendSpace(buf, spaceEach + (j - lastI < spaceExtra ? 1 : 0));
                    }
                }
                result.add(buf.toString());
                lastI = i;
                curLen = 0;
            }
            if (i < wordsCount)
                curLen += words[i].length();
        }
        return result;
    }

    private void appendSpace(StringBuffer sb, int count) {
        for (int i = 0; i < count; i++)
            sb.append(' ');
    }
}
