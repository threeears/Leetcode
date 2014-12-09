import java.util.List;
import java.util.ArrayList;
public class Solution {
    public static void main(String[] args){
        Solution test = new Solution();
        System.out.println(test.generate(Integer.parseInt(args[0])));
    }
    public List<List<Integer>> generate(int numRows) {
        // row i suppose to have i  numbers, 1, i-1,...., i-1, 1
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows>1){// because backtracking stops at (1,1), we have to add additional level 0
             List<Integer> row = new ArrayList<Integer>();
             row.add(1);
             result.add(row);
        }

        getNum(numRows, result);
        return result;
    }
     public List<Integer> getNum(int numRows,List<List<Integer>> result){
        List<Integer> row = new ArrayList<Integer>();
        if(numRows==0) return row;//if num==0 return []
        if(numRows ==1){
            row.add(1);
            result.add(row);
            return row;
        }
        else if(numRows==2){
            row.add(1);
            row.add(1);
        }
        else{
            List<Integer> preRow = new ArrayList<Integer>();
            preRow = getNum(numRows-1,result);
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
        result.add(row);
        return row;
     
    }
}