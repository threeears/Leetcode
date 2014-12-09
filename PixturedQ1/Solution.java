/* Zichen(Zoe) Nie
 * Date: Nov.7th,2014
 * Find minimum symmetric binary root for positive integer N.
 */
class Solution{
	public int solution(int N){
	// can be converted to, N/2^k = Odd * bit_rev(Odd), k>=0;find the minimum odd.
		int largestOdd = N;
		int remain = largestOdd % 2;
		while(remain==0){
			largestOdd = largestOdd / 2;
			remain = largestOdd % 2;
		}
		if(largestOdd == 1) return N;// if N=2^k, k is a positive integer, bit_rev(N)=1


		int i =1;
		while(i<= Math.ceil(Math.sqrt(largestOdd))){// from i to sqrt(largestOdd), save computation
			int reverse=bit_rev(i);

			if(largestOdd == reverse * i){

				return (N / largestOdd ) * i;
			}
			i = i+2;
		}		
		return -1;
	}

   public int bit_rev(int A){
   	  int result = 0;
   	  while(A!=0){
   	  	result = result*2 + A%2;
   	  	A = A/2;
   	  }
   	  return result;
   }
}