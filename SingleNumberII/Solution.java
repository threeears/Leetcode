// Given an array of integers, every element appears three times except for one. Find that single one.

// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

import org.junit.Test;


public class Solution {
    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int result=0;
        int[] bits=new int[32];//constant array also count as no extra memory
        for (int i = 0; i < 32; i++) {
            for(int j = 0; j < A.length; j++) {
                bits[i] += A[j] >> i & 1;//count the sum of 1 on this bit position
                bits[i] %= 3;
            }

            result |= (bits[i] << i);//resolve to previous position 
        }
        return result;
    }
    int singleNumber2(int[] A) {
                 int[] bit = new int[32];
                 int n =A.length;
         
                  for(int i =0; i< n; ++i)
                  {
                      int k=1;
                      for(int j =0; j<32; ++j)
                    {
                          int rotated;
                         if((rotated = A[i]>>j) == 0) break;
                         bit[j] += rotated & k;
                     }
                 }
                 
                 int target=0;
                 for(int i =0; i<32; ++i)
                 {
                     target += (bit[i]%3 <<i);
                 }
                 return target;
             }
    
    int singleNumber3(int A[]) {
        int n = A.length;
        int x = 0x0, y = 0x0;
        for (int i = 0; i < n; i++) {
            x ^= ~ y & A[i];
            y ^= ~ x & A[i];
        }
        return x;
    }
    @Test
    public void test(){
        int[] A={2,3,3,3};
        System.out.println(singleNumber2(A));
    }
}