// Given an integer, convert it to a roman numeral.

// Input is guaranteed to be within the range from 1 to 3999.

/*
 * 1I, 5V, X10, 50L, 100C, 500D, 1000M
 *
*/
public class Solution {
   public String intToRoman(int num) {
	    	String[] roman = new String[4000];
	    	String snum = Integer.toString(num);
	    	int length = snum.length();
	    	String result="";
	    	// learning pattern
	    	roman[0]="";
	    	roman[1]="I";
	    	roman[2]="II";
	    	roman[3]="III";
	    	roman[4]="IV";
	    	roman[5]="V";
	    	roman[6]="VI";
	    	roman[7]="VII";
	    	roman[8]="VIII";
	    	roman[9]="IX";
	    	
	    	while(length>=1){
	    		if(num % (Math.pow(10,length-1))==0){//remain is zero
	    			result += timesBase(roman[(int) (num/(Math.pow(10,length-1)))],(length-1));
	    			break;
	    		}
	    		else{// remain is not zero but from 1-9
	    			int ans= (int) (num/Math.pow(10,length-1));//integer answer after divided
	    			result+=timesBase(roman[ans],(length-1));
	    			num=(int) (num%(Math.pow(10,length-1)));//turn to its remain
	    			length--;

	    		}
	    	}
	    	
	    return result;
	        
	    }
	    public String timesBase(String input, int base){
	    	//base:1:10, 2:100, 3:1000
	    	//input belongs to 1-9 of Roman
	    	String output="";
	    	int length = input.length();
			char[] unit={'I','V','X','L','C','D','M'}; 
			HashMap<Character, Integer> map = new HashMap<Character,Integer>(); 
			map.put('I',1);
			map.put('V',2);
			map.put('X',3);
			map.put('L',4);
			map.put('C',5);
			map.put('D',6);
			map.put('M',7);  
	    	
	    	for(int i = 0;i<length;i++){
	    		int outputValue = map.get(input.charAt(i))+2*base;
	    		output+=unit[outputValue-1];
	    	}
	    	
	    	return output;
	    }
	    //time: O(n)? spaceO(1)
}