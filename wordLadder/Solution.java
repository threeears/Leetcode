import java.util.*;

public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("log");
		dict.add("dog");

		dict.add("lot");
		dict.add("dot");

		System.out.println(test.ladderLength2("hit", "cog", dict));

		System.out.println(test.ladderLength("hit", "cog", dict));

		
	}
    public int ladderLength2(String start, String end, Set<String> dict) {
        Queue<String> visited = new LinkedList<String>();//parents
        Queue<String> children = new LinkedList<String>();//children
        String[] dictionary  = new String[dict.size()];
        dict.toArray(dictionary);
        HashMap<String, Boolean> map = new HashMap<String,Boolean>();
        int depth = 0;
        int minDepth = Integer.MAX_VALUE/2;
//visited: log,dot
//children:
// hashmap:hit,hot,lot,dot,log
        visited.add(start);

        while(visited.isEmpty()==false){
        	String top = visited.poll();
        	map.put(top,true);
        	
        	for(int i = 0;i<dictionary.length;i++){// this step is too wasteful!! not wise
        			if(isEdge(dictionary[i],top)==true && map.containsKey(dictionary[i])==false){
        				children.add(dictionary[i]);
        			}
        		}
        
        	if(isEdge(top,end)==true){// reach end
        		 depth++;
        		 minDepth = minDepth>depth?depth:minDepth;
        	}
        	else if(visited.isEmpty()==true){// visited is empty
        		depth++;
        		while(children.isEmpty()==false)// if one layer has visted, input all its children
        		{
        			if(map.containsKey(children.peek())==false)
        				visited.add(children.poll());
        			else children.poll();
        		}

        	}
        	else{};
        }
       return minDepth+1;
    }
    boolean isEdge(String str1, String str2){
    	int i = 0;
    	int count = 0;
    	for(;i<str1.length();i++){
    		if(str1.charAt(i)!=str2.charAt(i))
    			count ++;
    	}
    	if(count==1)
    		return true;
    	else
    		return false;
    }
    
    // not the optimal solution
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
            return 0;
        }

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        int length = 1;

        while(!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i<count; i++){// That's the clever step, no matter how many elements are added behind, always
            	//visit first constant number of element, which is in the same layer.
                String current = queue.poll();
                for (char c = 'a'; c <= 'z'; c++) {// brilliant to check child
                    for (int j=0; j < current.length(); j++) {
                        if (c == current.charAt(j)) {
                            continue;
                        }
                        String tmp = replace(current, j, c);
                        if (tmp.equals(end)) {
                            return length + 1;
                        }
                        if (dict.contains(tmp)){
                            queue.offer(tmp);
                            dict.remove(tmp);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}