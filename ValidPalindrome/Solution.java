// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.

// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.

// For the purpose of this problem, we define empty string as valid palindrome.


// ask interviewee, empty is valid or not first
public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		System.out.println(test.skip("1001,100001"));
	}
    public boolean isPalindrome(String s) {
        if(s.equals("")) return true;
        s =  skip(s);
    	boolean[][] ispal = new boolean[s.length()][s.length()];

    	
    	palidromHelper(s,ispal,0,s.length()-1);

       return ispal[0][s.length-1];
    }
// to wastful
    public Boolean palidromHelper(String s, boolean[][] ispal,int start, int end){
    	if(end=start) ispal[start][end]=true;
    	if(end-start==1 && s.charAt(0)==s.charAt(1)) ispal[start][end]=true;
    	if((s.charAt(start)==s.charAt(end) || Math.abs(s.charAt(start)-s.charAt(end))=='A'-'a')
    		&& palidromHelper(s,ispal,start+1,end-1)
    	{
    		ispal[start][end]=true;
    	}
    	else{
    		ispal[start][end]=false;
    	}

    	return ispal[start][end];

    }

    public String skip(String s){
    	StringBuilder sb = new StringBuilder();
    	int i = 0;
    	while(i<s.length()){
    		String tmp = s.charAt(i)+"";
    		if(tmp.matches("[a-zA-Z]*[0-9]*")){
    			sb.append(tmp);
    		}
    		i++;
    	}
    	return sb.toString();
    }
// best solution
    public boolean isPalindrome(String s){
		if(s==null||s.length()==0) return true;
 
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		for(int i = 0; i < s.length() ; i++){
			if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
				return false;
			}
		}
 
		return true;
	}
	//ninechapter
	public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            while (front < s.length() && !isvalid(s.charAt(front))){ // nead to check range of a/b
                front++;
            }

            if (front == s.length()) { // for emtpy string “.,,,”     
                return true; 
            }           

            while (end >= 0 && ! isvalid(s.charAt(end))) { // same here, need to check border of a,b
                end--;
            }

            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                break;
            } else {
                front++;
                end--;
            }
        }

        return end <= front; 
    }

    private boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
}