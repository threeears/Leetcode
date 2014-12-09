public class Solution{
	

public class Divide_Integer {

	public static void main(String[] args) {		
		System.out.println(test.divide(2147483647, 3));	
		System.out.println(test.divide(-1073741824*2, 1));

	}
	public int divide(int dividend, int divisor) {
//		if dividend and divisor is of same direction/different directoin, regard as same direction, positive
//		 and add dirction in the end
//		 use abs() for int, however, -2^31 does not has abs(value), check boundry or use long instead
//		long dv = Math.abs(dividend);
		long ds = Math.abs((long)divisor);
		long left =Math.abs((long)dividend);
		if(divisor==1) return dividend;
		else if(divisor==-1) return -dividend;// make it special ecspeciall one the Max.Integer occurs, result will not 
		if(left - ds<0) return 0;
		System.out.println("abs:dv, ds:"+left+","+ds);
		long result =0;
		int plus = 0;
		int t = 0;
		int minus = 0;
		while(Math.abs(left) > Math.abs((long)divisor)){//we want jump out of loop if |left|<|divisor|
			plus = minus;
			while(left > Math.abs((long)divisor)){
					ds =  ds << 1 ;
					left = left - ds;
					plus ++;
					result = result + (1<<plus);	// move plus bit from 2 == multiply 2^plus
					t = 1<<plus;
					System.out.println("plus:"+plus+" ds:"+ds+" left:"+left+" 1<<plus:"+ t +" result="+ result );

			}
			if(Math.abs(left) <= Math.abs((long)divisor)) break;
			
			minus = plus;
			while(left < -Math.abs((long)divisor) ){
				    ds = ds >> 1;
					left = left + ds;
					minus --;
					result = result - (1<<minus);
					int f = 1<<minus;
					System.out.println("minus:"+minus+" ds:"+ds+" left:"+left+" t<<minus:"+ f+" result="+ result);

			}
		}
			
		if(left < 0) result --;
		else if(left > 0 && Math.abs(left) == Math.abs((long)divisor))
			result ++;
		else{};
		
		if(divisor<0 && dividend >=0 || divisor > 0 && dividend < 0)
			result = -result;	
		return (int) result;
	}
	//O(log(n));

}

