// Given two numbers represented as strings, return multiplication of the numbers as a string.

// Note: The numbers can be arbitrarily large and are non-negative.
public class Solution {
  // my initial solution, did not get it in the second round
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
       		

// second round inspired by TaoGe's, O(m*n) O(n)
        public String multiply(String num1, String num2) {
        if(num1==null || num2==null || num1.length()==0 || num2.length()==0) return "0";
        if(num1.equals("0") || num2.equals("0")) return "0";
        int[] res = new int[num1.length()+num2.length()-1];
        for(int i = 0;i<num1.length();i++)
            for(int j = 0;j<num2.length();j++){
                res[num1.length()-1-i+num2.length()-1-j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        int flag=0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<res.length;i++){
            res[i]+=flag;
            flag=res[i]/10;
            res[i]=res[i]%10;
            sb.insert(0,res[i]+"");
        }
        if(flag>0) sb.insert(0,flag+"");
        return sb.toString();
  }

}