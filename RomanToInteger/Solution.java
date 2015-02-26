// Given a roman numeral, convert it to an integer.

// Input is guaranteed to be within the range from 1 to 3999.

/*
 * 1I, 5V, X10, 50L, 100C, 500D, 1000M
 *
*/

public class Solution {
  public int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int i = 0;
        int res = 0;
        while(i<s.length()){
            int this_num = map.get(s.charAt(i));
            if(i+1<s.length())
            {
                int next_num = map.get(s.charAt(i+1));
                if(this_num<next_num){
                    res -= this_num;
                    i++;
                    continue;
                }
            }        
            res +=this_num;
            i++;
        }
        return res;
    }
}