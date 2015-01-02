// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string text, int nRows);
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".



public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		String s = "PAYPALISHIRING";
		System.out.println(test.convert(s,3));
	}
    public String convert(String s, int nRows) {
        // pattern is 2n-2 a peroid 
        int total = s.length();
        if(total==0 || total==1 || nRows==1) return s;
        int periods = (int) Math.ceil(total*1.0/(2*nRows-2));
        char[][] zigzag = new char[periods*(nRows-1)][nRows];
        
        int count=0;
        
        for(int i = 0;i<zigzag.length;i++){
            for(int j = 0;j<nRows; j++){
                if(count<total){
                    if(i%(nRows-1)==0){
                        zigzag[i][j]=s.charAt(count);
                        count++;
                    }
                    else{
                        int remain=i%(nRows-1);
                        zigzag[i][nRows-1-remain]=s.charAt(count);
                        count++;
                        break;
                    }
                    
                }
                else
                    break;
            }
        }
        
        StringBuilder result = new StringBuilder();
        for(int i = 0; i< nRows; i++){
            for(int j = 0; j<zigzag.length;j++){
                if(zigzag[j][i]!='\u0000'){//default value for null character
                    result.append(zigzag[j][i]);
                }
            }
        }
        return result.toString();
    }
}