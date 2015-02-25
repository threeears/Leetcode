// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string text, int nRows);
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".



public class Solution {
	
// O(n), O(n)
     public String convert(String s, int nRows) {
        // pattern is 2n-2 a peroid 
        int total = s.length();
        if(total==0 || total==1 || nRows==1) return s;
        List<StringBuilder> res = new ArrayList<StringBuilder>();
        for(int i = 0;i<nRows;i++){
            res.add(new StringBuilder());
        }
        
        for(int i = 0;i<s.length();i =i+2*(nRows-1)){
            int count = 0;
            for(int j = i;j<2*(nRows-1)+i && j<s.length();j++){
                if(count<nRows){
                    res.get(count).append(s.charAt(j));
                    count++;
                }
                else{
                    // critical point
                    res.get(count-j%(nRows-1)-1).append(s.charAt(j));
                }
            }
        }
        
        for(int i = 1;i<nRows;i++){
            res.get(0).append(res.get(i));
        }
        
        return res.get(0).toString();
    }

    // Better version, different thoughts, save spaces!
    public String convert2(String s, int nRows) {
    if (nRows == 1) return s;
    StringBuilder sb = new StringBuilder();
    char[] chars = s.toCharArray();
    for (int i = 0; i < nRows; i++) {
        for (int j = i; j < s.length(); j += 2*nRows - 2) {
            sb.append(chars[j]); // add vertical pillor
            if (i > 0 && i < nRows - 1 && j + (nRows - i - 1)*2 < s.length()) {
                sb.append(chars[j + (nRows - i - 1)*2]); // add slash
            }
        }
    }
    return sb.toString();
}
}