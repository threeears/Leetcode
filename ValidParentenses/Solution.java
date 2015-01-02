public class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        if(s.length()<=1) return false;
        st.push(s.charAt(0));
        int i = 0;
        while(i<s.length()-1){
            if(st.isEmpty()){
                st.push(s.charAt(i+1));// if empty, add the next
            }
            else{
                char top = st.peek();//if not empty, check top to see if match
                if(top=='(' && s.charAt(i+1)==')' || top=='[' && s.charAt(i+1)==']'||
                 top=='{' && s.charAt(i+1)=='}'){
                        st.pop();
                }
                else{
                    st.push(s.charAt(i+1));
                }
            }
            i++;
        }
        if(st.isEmpty())//can simplify!!
            return true;
        else 
            return false;
    }
    //nine chapter
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if ("({[".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && is_valid(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean is_valid(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
                || (c1 == '[' && c2 == ']');
    }
}