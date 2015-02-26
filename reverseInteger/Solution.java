import java.util.ArrayList;
public class Solution {
    // from solution, why 214748364? tricky!
    // Max.Integer 2,147,483,647

    public int reverse2(int x) {
       int ret = 0;
       while (x != 0) {
          // handle overflow/underflow
          if (Math.abs(ret) > 214748364) {
             return 0;
          }
          ret = ret * 10 + x % 10;
          x /= 10;
       }
    return ret;
   }

   public int reverse(int x) {
        long abs = Long.parseLong(new StringBuilder(Long.toString(Math.abs((long) x))).reverse().toString());
        if (abs > Integer.MAX_VALUE) abs = 0;
        return  x < 0 ? -(int)abs : (int)abs;
    }
}