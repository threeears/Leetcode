//Divide two integers without using multiplication, division and mod operator.
public class Solution {
    public int divide(int dividend, int divisor) {
        //System.out.println(divisor);
        int left=Math.abs(dividend);
        int result=0;
        while(left>=0){
            left = Math.abs(left) - Math.abs(divisor);
            //System.out.println(left);
            if((dividend >= 0 && divisor > 0) || (dividend <=0 && divisor<0)){
                result ++;
            }
            else result --;
        }
        if(left!=0 && ((dividend > 0 && divisor < 0) || (dividend <0 && divisor>0)))
            result ++;
        else result --;
        return result;
        
    }
}

//O(n), combine all the condition for 4 different cases