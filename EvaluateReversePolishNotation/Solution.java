import java.util.Stack;
// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

// Valid operators are +, -, *, /. Each operand may be an integer or another expression.

// Some examples:
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
public class Solution {

	// can be more concise with hashset solutoin
	public static void main(String[] args){
		String[] takens = new String[3];
		takens[0]="0";
		takens[1]="1";
		takens[2]="/";
		Solution test = new Solution();
		System.out.println(test.evalRPN(takens));
	}
    public int evalRPN(String[] tokens) {
    	Stack<Integer> st = new Stack<Integer>();
    	int i = 0;
    	while(i<tokens.length){// string equal cannot use "==", has to use equal()
    		if(tokens[i].equals("+")){
    			int result=st.pop()+st.pop();
    			st.push(result);
    		}
    		else if (tokens[i].equals("-")){
    			int operater = st.pop();
    			int result = st.pop()-operater;    
    			st.push(result);
    		}
    		else if(tokens[i].equals("*")){
    			int result = st.pop()*st.pop();
    			st.push(result);
    		}
    		else if(tokens[i].equals("/")){
    			int operater = st.pop();
    			int result = st.pop()/operater;
    			st.push(result);
    		}
    		else{
    				st.push(Integer.parseInt(tokens[i]));
    		}
            i++;
    	}
    		return st.pop();

        }
    }

