//Determine whether an integer is a palindrome. Do this without extra space.
// Some hints:
// Could negative integers be palindromes? (ie, -1)

// If you are thinking of converting the integer to string, note the restriction of using extra space.

// You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

// There is a more generic way of solving this problem.

public class Solution {
	public static void main(String[] args)
{
	Solution test = new Solution();
	System.out.println(test.isPalindrome(Integer.parseInt(args[0]+"")));
}
//negative is not palindrom
//run alogrithm, 1000021 is the bad case
//without using extra space means a little extra space can be used, "No extra space"
// implies some amount of space, usually exactly n, is available via the input, and no more should be used,
    public boolean isPalindrome2(int x) {
    	// x/2*10*x.length-1==x/2*10*0
    	// x/2*10*x.length-2 == x/2*10*1
    	//5675 - 5005 = 670
    	if(x<0) return false;// make it positive;// notice!! -2^31 does not have a positive number
    	if(x>=0 && x<10) return true;
    	if(Integer.toString(x).length()==2) {
    		if(x%11==0)
    			return true;
    		else
    			return false;
    	}
    	else /*if(Integer.toString(x).length()>=3)*/{
    		System.out.println("large:"+Integer.toString(x).charAt(0));
 		System.out.println(Math.pow(10,(Integer.toString(x).length()-1)));
    		 x = x - (Integer.parseInt(Integer.toString(x).charAt(0)+"")
    		 		*(int)Math.pow(10,(Integer.toString(x).length()-1)))
    		 		-Integer.parseInt(Integer.toString(x).charAt(0)+"");


 	

    		 if(Integer.toString(x).charAt(Integer.toString(x).length()-1)=='0'){
    		 	System.out.println(x/10);
    		 	return isPalindrome(x/10);
    		 }
    		 else
    		 	return false;

    	}
        
    }
     public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        return x == reverse(x);    
    }
    
    public int reverse(int x) {// reversed integer might overflow, if overflow, it turns to negative
    	// then, not a palidrome
        int rst = 0;
        while(x != 0) {
            rst = rst * 10 + x % 10;
            x = x / 10;
        }
        System.out.println(rst);
        return rst;
    }

}