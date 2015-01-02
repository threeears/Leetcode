// Given two words (start and end), and a dictionary, 
//find all shortest transformation sequence(s) from start to end, such that:

// Only one letter can be changed at a time
// Each intermediate word must exist in the dictionary
// For example,

// Given:
// start = "hit"
// end = "cog"
// dict = ["hot","dot","dog","lot","log"]
// Return
//   [
//     ["hit","hot","dot","dog","cog"],
//     ["hit","hot","lot","log","cog"]
//   ]
// Note:
// All words have the same length.
// All words contain only lowercase alphabetic characters.

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
	   int min=Integer.MAX_VALUE;

	   //version 1, find all possible solution and return the shortest solutions.
	   public List<List<String>> findLadders(String start, String end, Set<String> dict) {
	      	List<List<String>>sol = new ArrayList<List<String>>();
	      	List<String> sub = new ArrayList<String>();
	      	sub.add(start);
	      	List<String> dic = new ArrayList<String>();
	      	dic.addAll(dict);
	      	dic.remove(start);
	      	dic.remove(end);
	      	helper(start, end, dic, sol, sub,min);
	      	if(sol.size()!=0)
	              {	int min=sol.get(0).size();
	              	for(List<String> res:sol){
	              		if(res.size()<min){
	              			min = res.size();
	              		}
	              	}
	              	for(int i=0;i<sol.size();i++){
	              		if(sol.get(i).size()!=min)
	              			{
	              				sol.remove(sol.get(i));
	              				i--;
	              			}
	              	}
	              }
	      	return sol;
	      }
	      int  helper(String start, String end, List<String>dict, List<List<String>>sol, List<String>sub,int min){
	      	if(isMatch(start, end)==true){
	      		sub.add(end);
	      		List<String> nsub = new ArrayList<String>();
	      		for(String str:sub)
	      			nsub.add(str);
	      		if(!sol.contains(nsub) && nsub.size()<=min)
	      		{   sol.add(nsub);
	      		    min = nsub.size();
	      			//System.out.println(nsub);
	      		}
	      		sub.remove(end);
	      		return 1;
	      	}
	      	

	      	int i = 0;
	          while(i<dict.size()){
	          	String foo=dict.get(i);
	          	if(isMatch(foo, start)==true)
	          	{	
	          		sub.add(foo);
	          		if(sub.size()>min){
	          		    sub.remove(foo);
	          		    continue;
	          		}
	          		dict.remove(foo);
	          		helper(foo, end, dict, sol, sub,min);	
	          		dict.add(foo);
	          	    sub.remove(foo);
	          		
	          	}
	          	i++;
	          }

	          return -1;
	      }
	       boolean isMatch(String a, String b){
	      	// check if only one character differs, only lower cases
	      	int count=0;
	      	if(a.equals(b)) return false;
	      	for(int i=0;i<a.length();i++){
	      		if(a.charAt(i)!=b.charAt(i))
	      		{
	      			 count++;
	      			 if(count>1)
	      			 	break;
	      		}
	      	}
	      	if(count!=1)
	      		return false;
	      	return true;
	      }









	      // version two, somewhere answer online, I did not check yet.
	       public ArrayList<ArrayList<String>> findLadders2(String start, String end, HashSet<String> dict) {  
         
         // Start typing your Java solution below  
         // DO NOT write main() function                
           
         HashMap<String, HashSet<String>> neighbours = new HashMap<String, HashSet<String>>();  
           
         dict.add(start);  
         dict.add(end);  
           
         // init adjacent graph          
         for(String str : dict){  
             calcNeighbours(neighbours, str, dict);  
         }  
           
         ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();  
           
         // BFS search queue  
         LinkedList<Node> queue = new LinkedList<Node>();  
         queue.add(new Node(null, start, 1));  
           
         // BFS level  
         int previousLevel = 0;  
           
         // mark which nodes have been visited, to break infinite loop  
         HashMap<String, Integer> visited = new HashMap<String, Integer>();   
         while(!queue.isEmpty()){  
             Node n = queue.pollFirst();              
             if(end.equals(n.str)){   
                 // fine one path, check its length, if longer than previous path it's valid  
                 // otherwise all possible short path have been found, should stop  
                 if(previousLevel == 0 || n.level == previousLevel){  
                     previousLevel = n.level;  
                     findPath(n, result);                      
                 }else {  
                     // all path with length *previousLevel* have been found  
                     break;  
                 }                  
             }else {  
                 HashSet<String> set = neighbours.get(n.str);                   
                   
                 if(set == null || set.isEmpty()) continue;  
                 // note: I'm not using simple for(String s: set) here. This is to avoid hashset's  
                 // current modification exception.  
                 ArrayList<String> toRemove = new ArrayList<String>();  
                 for (String s : set) {  
                       
                     // if s has been visited before at a smaller level, there is already a shorter   
                     // path from start to s thus we should ignore s so as to break infinite loop; if   
                     // on the same level, we still need to put it into queue.  
                     if(visited.containsKey(s)){  
                         Integer occurLevel = visited.get(s);  
                         if(n.level+1 > occurLevel){  
                             neighbours.get(s).remove(n.str);  
                             toRemove.add(s);  
                             continue;  
                         }  
                     }  
                     visited.put(s,  n.level+1);  
                     queue.add(new Node(n, s, n.level + 1));  
                     if(neighbours.containsKey(s))  
                         neighbours.get(s).remove(n.str);  
                 }  
                 for(String s: toRemove){  
                     set.remove(s);  
                 }  
             }  
         }  
   
         return result;  
     }  
       
     public void findPath(Node n, ArrayList<ArrayList<String>> result){  
         ArrayList<String> path = new ArrayList<String>();  
         Node p = n;  
         while(p != null){  
             path.add(0, p.str);  
             p = p.parent;   
         }  
         result.add(path);  
     }  
   
     /* 
      * complexity: O(26*str.length*dict.size)=O(L*N) 
      */  
     void calcNeighbours(HashMap<String, HashSet<String>> neighbours, String str, HashSet<String> dict) {  
         int length = str.length();  
         char [] chars = str.toCharArray();  
         for (int i = 0; i < length; i++) {  
               
             char old = chars[i];   
             for (char c = 'a'; c <= 'z'; c++) {  
   
                 if (c == old)  continue;  
                 chars[i] = c;  
                 String newstr = new String(chars);                  
                   
                 if (dict.contains(newstr)) {  
                     HashSet<String> set = neighbours.get(str);  
                     if (set != null) {  
                         set.add(newstr);  
                     } else {  
                         HashSet<String> newset = new HashSet<String>();  
                         newset.add(newstr);  
                         neighbours.put(str, newset);  
                     }  
                 }                  
             }  
             chars[i] = old;  
         }  
     }  
       
     private class Node {  
         public Node parent;  
         public String str;  
         public int level;  
         public Node(Node p, String s, int l){  
             parent = p;  
             str = s;  
             level = l;  
         }  
     } 


     @Test
     public void test(){
    	 Set<String> set = new HashSet<String>();
    	 set.add("dot");
    	 set.add("dog");
    	 set.add("lot");
    	 set.add("log");
    	 set.add("hot");
    	 set.add("cot");
    	 set.add("dig");

    	 
    	 HashSet<String> set2 = new HashSet<String>();
    	 set2.add("dot");
    	 set2.add("dog");
    	 set2.add("lot");
    	 set2.add("log");
    	 set2.add("hot");
    	 set2.add("cot");
    	 set2.add("dig");
    	 System.out.println(findLadders("hit","cog",set));
    	 System.out.println(findLadders2("hit","cog",set2));
     }
}

// from ninechapter
public class Solution {
    public List<List<String>> findLadders(String start, String end,
            Set<String> dict) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();

        dict.add(start);
        dict.add(end);
 
        bfs(map, distance, start, end, dict);
        
        List<String> path = new ArrayList<String>();
        
        dfs(ladders, path, end, start, distance, map);

        return ladders;
    }

    void dfs(List<List<String>> ladders, List<String> path, String crt,
            String start, Map<String, Integer> distance,
            Map<String, List<String>> map) {
        path.add(crt);// end node first?
        if (crt.equals(start)) {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String next : map.get(crt)) {
                // for key word, crt, find all the prior node to it.
                if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) { 
                    dfs(ladders, path, next, start, distance, map);
                }
            }           
        }
        path.remove(path.size() - 1);
    }

    void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
            String start, String end, Set<String> dict) {
                // find every possible route in dictionary, because it is BFS, it already the shortest path.
                //the size of the graph would be at most n*n
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<String>());//map is used to record all the previous node in dictionary
        }
        
        while (!q.isEmpty()) {
            String crt = q.poll();

            List<String> nextList = expand(crt, dict);
            for (String next : nextList) {
                map.get(next).add(crt);//add the pre-node to current word in dict, each list in the map, preserved the one-step prior to the key of the list.
                if (!distance.containsKey(next)) {
                    //if the word is not in current path, add it in the path with its position of the path
                    distance.put(next, distance.get(crt) + 1);
                    q.offer(next);
                }
            }
        }
    }

    List<String> expand(String crt, Set<String> dict) {
        //find all possible next word dictionry of current string
        List<String> expansion = new ArrayList<String>();

        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != crt.charAt(i)) {
                    String expanded = crt.substring(0, i) + ch
                            + crt.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }

        return expansion;
    }
}











