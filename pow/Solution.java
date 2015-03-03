// Implement pow(x, n).
public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		System.out.println(test.pow(-13.62608, 3));
		System.out.println(Math.pow(-13.62608, 3));
	}

	// naive solution, takes O(n) // iterative
     public double pow(double x, int n) {
        if(n==0) return 1;
        if(x==0) return 0;// x=0,1 n=0,are special cases
        if(n<0) {
        	x = 1/x;
        	n = -n;
        }
        if(x==1)// 1 is very special, save computation
            return 1;
        else if(x==-1)
            return n%2<1?1:-1;
        else{
        double result = 1.0;
        while(n>0){
        	result = result * x;
        	System.out.println(result);
        	if(result<0.0000001 && result > -0.0000001){// adjust precision!! to reduce complexity
        		break;
        	}
        	n= n-1;
        }
        return result;
        }
    }

    // recurrsive O(lgn) binary, much faster!
    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n *= -1;
        }

        int k = n / 2;
        int l = n - k * 2;
        double t1 = pow(x, k);
        double t2 = pow(x, l);
        if (isNegative) {
            return 1/(t1*t1*t2);
        } else {
            return t1*t1*t2;
        }
    }
    // more concised version fo divide and Conqure
    public double pow(double x, int n) {
        if (n==0)   return 1.0;
        double val = pow(x, n/2);
        if (n%2==0) return val*val;
        return n>0 ? val*val*x : val*val/x;  // notice not 1/(val*val*x) here, understand why
    }
}