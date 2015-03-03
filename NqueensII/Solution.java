//N Queens II , give the number of distinct solutions
// backtracking similar to mine
public int totalNQueens(int n) {
        if (n == 0) return 0;
        int[] num = new int[1];
        int[] rows = new int[n];
        Arrays.fill(rows, -1);
        finder(rows, 0, num);
        return num[0];
    }
    
    public void finder(int[] rows, int x, int[] num){
        if (x == rows.length){
            num[0]++;
            return;
        }
        for (int i =0; i < rows.length; i++){
            if (isValid(rows, x, i)){
                rows[x] = i;
                finder(rows, x+1, num);
                rows[x] = 0;
            }
        }
    }
    
    public boolean isValid(int[] rows, int x, int y){
        for (int i=0; i<x; i++){
            if (rows[i]==y || x-i==Math.abs(rows[i]-y)) return false;
        }
        return true;
    }