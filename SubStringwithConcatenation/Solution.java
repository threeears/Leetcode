import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
   // my brute force method
    // critical at use two HashMap!
    public List<Integer> findSubstring(String S, String[] L){
    	List<Integer> res = new ArrayList<Integer>();
		HashMap<String, Integer> table= new HashMap<String,Integer >();
		for(int i = 0;i<L.length;i++){
			int num = 1;
			if(table.containsKey(L[i])){
				table.put(L[i], table.get(L[i])+1);
			}
			else{
				table.put(L[i], 1);
			}			
		}
    	int wordLen = L[0].length();
    	int matLen = L[0].length() * L.length;
    	
    	for(int i = 0;i<=S.length()-matLen; i ++){
    		String temp = S.substring(i,i+matLen);
    		HashMap<String, Integer> match = new HashMap<String,Integer>();
    		int j = 0;// see temp if match
    		for(j = 0;j<=matLen-wordLen;j= j+wordLen){
    			String word = temp.substring(j,j+wordLen);
    			if(table.containsKey(word)){
    				if(match.containsKey(word)){
    					match.put(word, match.get(word)+1);
    				}
    				else{
    					match.put(word, 1);
    				}
    				if(match.get(word)>table.get(word))
    					break;// stop searching because no longer match 
    			}
    			else
    				break;// stop searching because no longer would match
    		}
    		if(j==matLen){
    			res.add(i);
    		//	i = i+matLen-1;
    		}
    	}
    	
    	return res;
    }

    // sliding window, better than mine, save compare steps
     public ArrayList<Integer> findSubstring2(String S, String[] L) {  
    // Note: The Solution object is instantiated only once and is reused by each test case.  
    ArrayList<Integer> res = new ArrayList<Integer>();  
    if(S==null || S.length()==0 || L==null || L.length==0)  
        return res;  
    HashMap<String,Integer> map = new HashMap<String,Integer>();  
    for(int i=0;i<L.length;i++)  
    {  
        if(map.containsKey(L[i]))  
        {  
            map.put(L[i],map.get(L[i])+1);  
        }  
        else  
        {  
            map.put(L[i],1);  
        }  
    }  
    for(int i=0;i<L[0].length();i++)  
    {  
        HashMap<String,Integer> curMap = new HashMap<String,Integer>();  
        int count = 0;  
        int left = i;  
        for(int j=i;j<=S.length()-L[0].length();j+=L[0].length())  
        {  
            String str = S.substring(j,j+L[0].length());  
              
            if(map.containsKey(str))  
            {  
                if(curMap.containsKey(str))  
                    curMap.put(str,curMap.get(str)+1);  
                else  
                    curMap.put(str,1);  
                if(curMap.get(str)<=map.get(str))  
                    count++;  
                else  
                {  // here is the difference between brute force
                    while(curMap.get(str)>map.get(str))  
                    {  
                        String temp = S.substring(left,left+L[0].length());  
                        if(curMap.containsKey(temp))  
                        {  
                            curMap.put(temp,curMap.get(temp)-1);  
                            // kick out the left most matched word, until satisfiy constraint
                            if(curMap.get(temp)<map.get(temp))  
                                count--;  
                        }  
                        left += L[0].length();  
                    }  
                }  
                if(count == L.length)  
                {  
                    res.add(left);  
                    //if(left<)  
                    String temp = S.substring(left,left+L[0].length());  
                    if(curMap.containsKey(temp))  
                        curMap.put(temp,curMap.get(temp)-1);  
                    count--;  
                    left += L[0].length();  // 三个三个试验， 即使已经匹配过了，左指针向右跳三格， 然后从不同起点分别出发，得到所有可能性
                }  
            }  
            else  
            {  
                curMap.clear();  
                count = 0;  
                left = j+L[0].length();  
            }  
        }  
    }  
    return res;  
}
}
