// Given an index k, return the kth row of the Pascal's triangle.

// For example, given k = 3,
// Return [1,3,3,1].

// Note:
// Could you optimize your algorithm to use only O(k) extra space?
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static void main(String[] args){
        Solution test = new Solution();
        System.out.println(test.getRow(Integer.parseInt(args[0])));
    }
    public List<Integer> getRow(int rowIndex) {
        // row i suppose to have i+1  numbers, 1, i-1,...., i-1, 1
        List<Integer> row = new ArrayList<Integer>();
        if(rowIndex ==0){
            row.add(1);
            return row;
        }
        else if(rowIndex==1){
            row.add(1);
            row.add(1);
        }
        else{
            List<Integer> preRow = new ArrayList<Integer>();
            preRow = getRow(rowIndex-1);
            for(int i = 0;i < preRow.size()+1; i++){
                if(i==0 || i == preRow.size())
                {
                    row.add(1);
                }
                else{
                    row.add(preRow.get(i-1)+preRow.get(i));
                }
            }
        }

        return row;
    }
}