public class Solution {
    public String minWindow(String S, String T) {
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];
         
        for(int i = 0; i < T.length(); ++i) {
            needToFind[T.charAt(i)]++;
        }
         
        int count = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int start = 0, end = 0;
        String window = "";
         
        for(; end < S.length(); end++) {
            if(needToFind[S.charAt(end)] == 0) continue;
            char c = S.charAt(end);
            hasFound[c]++;
             
            if(hasFound[c] <= needToFind[c]) {
                count++;
            }
             
            if(count == T.length()) {
                while(needToFind[S.charAt(start)] == 0 ||
                    hasFound[S.charAt(start)] > needToFind[S.charAt(start)]) {
                    if(hasFound[S.charAt(start)] > needToFind[S.charAt(start)])
                        hasFound[S.charAt(start)]--;
                    start++;
                }
                 
                if(end - start + 1 < minWindowSize) {
                    minWindowSize = end - start + 1;
                    window = S.substring(start, end + 1);
                }
            }
        }
         
        return window;
    }
}
// O(n) using ASCII 





public String minWindow(String S, String T) {  
    if(S == null || T == null || S.length()==0 || T.length()==0)  
        return "";  
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();  
    for(int i=0;i<T.length();i++)  
    {  
        if(map.containsKey(T.charAt(i)))  
        {  
            map.put(T.charAt(i), map.get(T.charAt(i))+1);  
        }  
        else  
            map.put(T.charAt(i), 1);  
    }  
    int count = 0;  
    int pre = 0;  
    String res = "";  
    int minLen = S.length()+1;  
    for(int i=0;i<S.length();i++)  
    {  
        if(map.containsKey(S.charAt(i)))  
        {  
            map.put(S.charAt(i),map.get(S.charAt(i))-1);  
            if(map.get(S.charAt(i))>=0)  
                count++;  
            while(count == T.length())  
            {  
                if(map.containsKey(S.charAt(pre)))  
                {  
                    map.put(S.charAt(pre),map.get(S.charAt(pre))+1);  
                    if(map.get(S.charAt(pre))>0)  
                    {  
                        if(minLen>i-pre+1)  
                        {  
                            res = S.substring(pre,i+1);  
                            minLen = i-pre+1;  
                        }  
                        count--;  
                    }  
                }  
                pre++;  
            }  
        }  
    }  
    return res;  
} 
// using harsh map



*
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

    For example,
    S = "ADOBECODEBANC"
    T = "ABC"
    Minimum window is "BANC".

    Note:
    If there is no such window in S that covers all characters in T, return the emtpy string "".

    If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

// Sliding Window 
// Maintain two arrays to record the occurrences of needed characters and found characters 
// Traverse the String S, update the occurrence arrays and the number of remaining chars that need to be found.
// When all needed chars haven been found, right shift the start index of window if possible, 
// and update the min window.
// time: O(n); space: O(n), each char is accessed at most twice
public class Solution {
    public String minWindow(String S, String T) {
        if (S==null || T==null)
            return "";
        int M = S.length(), N = T.length();
        if (M<N)
            return "";
        int[] need = new int[256], find = new int[256];
        for (int i=0; i<N; i++)
            need[(int)T.charAt(i)]++;
        int start = 0, minStart = -1, minEnd = M; // make sure the initial value of minEnd-minStart is big enough
        for (int i=0; i<M; i++){
            int ch = (int) S.charAt(i);
            if (find[ch]<need[ch])
                N--;
            find[ch]++;
            if (N==0){
                start = getStartIndex(need, find, S, start);
                if (i-start<minEnd-minStart){
                    minEnd = i; minStart = start;
                }
            }
        }
        return minStart==-1?"": S.substring(minStart, minEnd+1);
    }
    
    private int getStartIndex(int[] need, int[] find, String S, int i){
        for (; i<S.length(); i++){
            int ch = (int) S.charAt(i);
            if (find[ch]>need[ch])
                find[ch]--;
            else
                break;
        }
        return i;
    }
}

// TLE, use a string to store min window, easy for update
public class Solution {
    public String minWindow(String S, String T) {
        if (S==null || T==null)
            return "";
        int M = S.length(), N = T.length();
        if (M<N)
            return "";
        int[] need = new int[256], find = new int[256];
        for (int i=0; i<N; i++)
            need[(int)T.charAt(i)]++;
        String min = "";
        int i = 0;
        for (int j=0; j<M; j++){
            int ch = (int) S.charAt(j);
            if (find[ch]<need[ch])
                N--;
            find[ch]++;
            if (N==0){
                i = getStartIndex(need, find, S, i);
                String s = S.substring(i, j+1);
                if (min.equals("") || min.length()<s.length())
                    min = s;
            }
        }
        return min;
    }
    
    private int getStartIndex(int[] need, int[] find, String S, int i){
        for (; i<S.length(); i++){
            int ch = (int) S.charAt(i);
            if (find[ch]>need[ch])
                find[ch]--;
            else
                break;
        }
        return i;
    }
}




