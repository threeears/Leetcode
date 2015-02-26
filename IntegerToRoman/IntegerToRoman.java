// Given an integer, convert it to a roman numeral.

// Input is guaranteed to be within the range from 1 to 3999.

/*
 * 1I, 5V, X10, 50L, 100C, 500D, 1000M
 *
*/
public class Solution {
   public String intToRoman(int num) {
	    	StringBuilder res = new StringBuilder();
	    	String[] table = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
	    	 
	    	int count = 1;
	    	while(num!=0){
	    	    String res_str = table[num%10];
	    	    int k = 1;
	    	    while(k<count){
	    	        res_str = multiplyTen(res_str);
	    	        k++;
	    	    }
	    	    res.insert(0,res_str);
	    	    num = num/10;
	    	    count++;
	    	}
	    	return res.toString();
	    }
	public String multiplyTen(String str){
         HashMap<Character, Character> map = new HashMap<Character,Character>();
             map.put('I', 'X');
	         map.put('X','C');
	         map.put('C','M');
	         map.put('V','L');
	         map.put('L','D');
	    	
	    StringBuilder res = new StringBuilder();
	   
	    for(int i = 0;i<str.length();i++){
	        res.append(map.get(str.charAt(i)));
	    }
	    return res.toString();
	}

	    // from nineChapter, better, more concise solution
	    public String intToRoman(int num) {
		if(num <= 0) {
			return "";
		}
	    int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    StringBuilder res = new StringBuilder();
	    int digit=0;
	    while (num > 0) {
	        int times = num / nums[digit];
	        num -= nums[digit] * times;
	        for ( ; times > 0; times--) {
	            res.append(symbols[digit]);
	        }
	        digit++;
	    }
	    return res.toString();
	}
}