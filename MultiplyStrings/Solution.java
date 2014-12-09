// Given two numbers represented as strings, return multiplication of the numbers as a string.

// Note: The numbers can be arbitrarily large and are non-negative.
public class Solution {
	public static void main(String[] args){
		String num1 = "9";
		String num2 = "9";
		Solution test = new Solution();
		System.out.println(test.multiply(num1, num2));
		
	}
    public String multiply(String num1, String num2) {

    	int[] result = new int[num1.length() + num2.length()];// not num1 * num2!!
    	for(int i=num1.length()-1;i>=0;i--){
    		for(int j=num2.length()-1;j>=0;j--){
    			SingleMultiply(i,num1,j,num2,result);
    		}
    	}
    	StringBuilder ans = new StringBuilder();
    	
    	int i = result.length-1;
    	while(i>=0 && result[i]==0)
    		i--;
    	if(i==-1) ans.append("0");// deal with 0 special case, for case 000, 
    	for(;i>=0;i--){
    		
    		ans.append(Integer.toString(result[i]));
    	}
        
    	return ans.toString();
       }

       public void SingleMultiply(int pos1, String num1, int pos2, String num2,int[] result){

       	// num1 is 乘数， num2 is 被乘数
       		int flag=0;
       		int position = num1.length()-1-pos1 +num2.length()-pos2-1;

       		int singleResult = Integer.parseInt(num1.charAt(pos1)+"") * Integer.parseInt(num2.charAt(pos2)+"")
       							+ result[position];
       		if(singleResult<10)
       			result[position] = singleResult;
       		else{

       			flag = singleResult/10;
       			result[position] = singleResult%10;
       			result[position+1] += flag;
       		}
       		

       }

}