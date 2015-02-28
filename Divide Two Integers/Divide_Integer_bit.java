public class Solution{
	

public class Divide_Integer {
	// my second round solution
 public int divide(int dividend, int divisor) {
        // check direction, same or not
        int flag=-1 ;
        if(dividend>0 && divisor >0 || dividend<0 && divisor<0){
            flag = 1;//of same direction
        }
        if(dividend==0) return 0;
        long first = Math.abs((long)dividend);// critical, if do not add long, there's no use of ..
        long second = Math.abs((long)divisor);
        if(first == second) return flag;
        
        long count = 0;
        long res = 0;
        while(first>=0){
            if(first<second) break;
            count = 0;
            long temp = 0;
            while(first - temp>=0){
                count++;//critical
            	temp = second<<count;//critical
            }
            count--;
            res += Math.pow(2,count);
            first = first - (second<<count);
        }
        
        if(res>Integer.MAX_VALUE && flag==1)
            return Integer.MAX_VALUE;
        else if(flag==-1 && res*flag<=Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        else return (int)res*flag;
	}

	// two method below cannot pass Leetcode but logic is right, only need a little modification

	// See Company/amazon/BitDivision
	// time: O(32); space: O(1)
    public int divide(int dividend, int divisor) {
        if (dividend==0)    return 0;
        long a = Math.abs((long)dividend), b = Math.abs((long)divisor);
        int res = 0, i=31;
        while (i>=0 && a>0){
            if ((a>>i)>=b){
                a -= (b<<i);
                res += (1<<i);
            }else   i--;
        }
        return (dividend^divisor)>=0? res: -res;
    }
   // three
    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 0)  return 0;
        long d = Math.abs((long)dividend);              // avoid overflow, abs(Integer.MIN_VALUE) = Integer.MIN_VALUE
        long s = Math.abs((long)divisor);
        Map<Integer, Long> map = new HashMap<Integer, Long>();      // divisor mapping
        int key = 0;
        while (s <= d){
            map.put(key++, s);
            s = s << 1;
        }
        int res = 0;
        while (--key >= 0 ){                // remember to '--' first
            if (d >= map.get(key)){
                d -= map.get(key);
                res += 1 << key;
            }
        }
        return (dividend > 0) ^ (divisor > 0) ? -res : res;     // ^ is both bitwise and logical XOR in java
    }
    
}

