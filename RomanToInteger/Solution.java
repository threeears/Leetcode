// Given a roman numeral, convert it to an integer.

// Input is guaranteed to be within the range from 1 to 3999.

/*
 * 1I, 5V, X10, 50L, 100C, 500D, 1000M
 *
*/

public class Solution {
     public int romanToInt(String s) {

    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	map.put("I",1);
    	map.put("V",5);
    	map.put("X",10);
    	map.put("L",50);
    	map.put("C",100);
    	map.put("D",500);
    	map.put("M",1000);

    	int i = 0;
    	int result = 0;
    	while(i<s.length()){
    		String rbit = s.charAt(i)+"";
    		if(i+1<s.length()){
    			String nxtbit = s.charAt(i+1)+"";
    			if(map.get(rbit)<map.get(nxtbit)){
    				result += map.get(nxtbit)-map.get(rbit);
    				i++;// one step furturer
    			}
    			else{
    				result += map.get(rbit);
    			}
    		}
    		else{
    			result +=map.get(rbit);
    		}
    		i++;
    	}
        return result;
    }
}