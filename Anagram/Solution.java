// Given an array of strings, return all groups of strings that are anagrams.
//[cat,dog,bog, tca,ogd]
// Note: All inputs will be in lower-case.
public class Solution {
	// sort str to see if equal, use hashmap to store formatted string
	// O(n)
	// use HashMap<String, ArrayList<String> to store, brilliant!!
	// can be return as arraylist!! notice
    public List<String> anagrams2(String[] strs) {
            
        ArrayList<String> result = new ArrayList<String>();
        
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        
        for(String str : strs){
            char[] tempstr= str.toCharArray();
            Arrays.sort(tempstr);
            String sortedstr = new String(tempstr);// turn the charArray back to string
            if(map.containsKey(sortedstr)){    
                map.get(sortedstr).add(str);
            }else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                map.put(sortedstr,list);          
            }        
        }
        
        for(ArrayList<String> list:map.values())
            if(list.size()>1)
                for(String str : list)
                    result.add(str);
                    
        return result;
    
    }
    // my mess solution:
    // O(n*m)? too native
    public List<String> anagrams(String[] strs) {
    	boolean[] foundAnagram = new boolean[strs.length];
    	List<List<String>> groups = new ArrayList<List<String>>();

    	for(int i = 0;i<strs.length;i++){
    		List<String> list = new ArrayList<String>();
    		list.add(strs[i]);// first put it in list

    		if(foundAnagram[i]==true){
    			continue;
    		}
    		else{
    			// put a string in hashmap
    			HashMap<Integer,Character> map = new HashMap<Integer,Character>();
    			for(int k=0;k<strs[i].length();k++){
    				map.put(k,strs[i].charAt(k));
    			}
    		

	    		for(int j=i+1; j<strs.length;j++){
	    			// find all strings that anagram with str[i]
	    			if(foundAnagram[j]==false && strs[j].length()==strs[i].length()){
	    				// not found before and maybe same because of same length
	    				boolean flag = true;
	    				int k = 0;
	    				for( k=0;k<strs[j].length();k++){
	    					// compare str[i] with each str[j],
	    					//if same, than add j to list, else, only i in list
	    					if(!map.containsValue(strs[j].charAt(k)))//compare every chars
	    						{flag = false; break;}
	    				}
	    					if(k==strs[j].length() && flag==true){
	    						foundAnagram[i] = true;
	    						foundAnagram[j] = true;
	    						list.add(strs[j]);
	    					}
	    					else{
	    						continue;
	    					}
	    				
	    			}
	    			else// compare with next one
	    				continue;
	    		}// end found all strings that anagram with str[i]
	    		map.clear();
	    		groups.add(list);
    		}
    	}
    	
    	List<String> result = new ArrayList<String>();
    	for(List temp: groups){
    		if(temp.size()==1)
    			continue;
    		else{
    			result.addAll(temp);
    		}
    	}
    	return result;
    }
}