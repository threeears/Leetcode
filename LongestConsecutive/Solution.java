import java.util.HashMap;

public class Solution {

    // got the idea, but a little wast in time O(n), O(n)
    public int longestConsecutive(int[] num) {
        int[] parent = new int[num.length];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();// key is the value, value is the index
       
        // initialize
        for(int i = 0;i<num.length;i++){
            parent[i]=i;
            map.put(num[i],i);
        }
        // find parent
        for(int i = 0;i<num.length;i++)
        {
            if(map.containsKey(num[i]+1)){
                int id = map.get(num[i]+1);
                parent[i]=id;
            }
            else if(map.containsKey(num[i]-1)){
                int id = map.get(num[i]-1);
                parent[id] = i;
            }
            
        }
        
        int max = 1;
        int i = 0;
        boolean[] visited = new boolean[num.length];
        // get length
        while(i<num.length){
            int current = 1;
            if(parent[i]!=i && visited[i]==false) 
            {
                int k = i;
                visited[i]=true;
                while(parent[k]!=k && k<num.length){
                    k = parent[k];
                    current++;
                    visited[k]=true;
                }
            }
            max = Math.max(max, current);
            i++;
        }
        
        return max;
    }


    // nineChapter, more concise, better
    public int longestConsecutive(int[] num) {
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(int i: num){
            hs.put(i, 0);
        }
        int maxl = 1;
        for(int i: num){
            if (hs.get(i) == 1) continue;// hash map store the index and # of parent
            // only find 1 parent is enough, this data structure is better than mime.

            int tmp = i;
            int current_max = 1;
            while(hs.containsKey(tmp+1)){
                current_max ++;
                tmp ++;
                hs.put(tmp, 1);// add directly? no need to remove first? seems so.一次找到大树顶， 好！
            }

            tmp = i;
            while(hs.containsKey(tmp-1)){
                current_max ++;
                tmp --;
                hs.put(tmp, 1);// 一次找到大树底， 好！
            }

            maxl = Math.max(current_max, maxl);
        }

        return maxl;
    }
}