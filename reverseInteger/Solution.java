import java.util.ArrayList;
public class Solution {
    public static void main(String[] args){
        Solution test = new Solution();
        System.out.println(test.reverse2(-2147648));

        System.out.println(test.reverse(-2147648));
    }

    // my solution is wasty in time and space
    public int reverse(int x) {
        int flag = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(x<0){
            flag=1;
            x = -x;
        }
        while(x!=0){
            int remain = x%10;
            arr.add(remain);
            x = x/10;
        }// get each element in the arr

        System.out.println(arr);
        
       int i = 0;
       while(i<arr.size() && arr.get(i)==0){
           i++;//find the first element that is larger than zero
       }
    
        int result = 0;
        for(;i<arr.size();i++){
            result = result*10 + arr.get(i);
            if(result<0)
                return 0;
        }
        
        if(flag==0)
            return result;
        else
            return -result;
        
    }
    // from solution, why 214748364? tricky!
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
}