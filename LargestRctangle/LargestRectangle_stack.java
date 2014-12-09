import java.util.Stack;

public class RectangleSearch {
    public int largestRectangleArea(int[] height) {
        int[] th = new int[height.length+1];
        th[height.length]= 0;
        for(int i=0;i<height.length;i++){th[i] = height[i];}
        Stack<Integer> st = new Stack<Integer>();
        int sum=0;
        st.push(0);
        for(int i = 1; i<th.length;i++){
            if(st.isEmpty() || th[i]>=th[st.peek()])//every time check stack if empty!
                    st.push(i);//push higer element, or its index?
            else{
                int top = st.pop();//get top index of element
                if(!st.isEmpty())// if not top is not the last one, combine all  rectangles larger than top
                    sum = Math.max(th[top] * (i-st.peek()-1), sum);
                else
                    sum = Math.max(th[top] * i, sum);//the last element in the stack is always the smallest one
                i--;
            }     
        }
        return sum; 
    }
}

//O(n), tricky solution, brilliant!
