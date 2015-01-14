// Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


// OJ's undirected graph serialization:
// Nodes are labeled uniquely.

// We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
// As an example, consider the serialized graph {0,1,2#1,2#2,2}.

// The graph has a total of three nodes, and therefore contains three parts as separated by #.

// First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
// Second node is labeled as 1. Connect node 1 to node 2.
// Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
// Visually, the graph looks like the following:

//        1
//       / \
//      /   \
//     0 --- 2
//          / \
//          \_/





import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Definition for undirected graph.*/
 class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };
 
public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
	}
  // my solution is very time consuming!!! but passed the test cases.
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode> ();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        
        q.add(node);//traverse the nodes in the graph

// create node put them in the map
       while(q.isEmpty()==false){
           UndirectedGraphNode temp = q.poll();
           if(map.get(temp)==null){
               //map does not contain the current node
               UndirectedGraphNode n = new UndirectedGraphNode(temp.label);
                map.put(temp,n);// first is origin node, second is the new node,
               for(int i = 0;i<temp.neighbors.size();i++){
            	   if(map.get(temp.neighbors.get(i)) == null)
            		   q.add(temp.neighbors.get(i));//may have duplicates
               }
           }
       }
       
// add new nodes' neighbours
       int length = map.size();
       for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> entry : map.entrySet()) {
            UndirectedGraphNode key = entry.getKey();
            UndirectedGraphNode value = entry.getValue();
            for(int i = 0;i<key.neighbors.size();i++){
                UndirectedGraphNode neighbor = map.get(key.neighbors.get(i));
                value.neighbors.add(neighbor);
            }
        }
        return map.get(node);
    }



    
    // from ninechapter, similar solution but more conveninet, but has bugs I think...maybe..
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map
            = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        // clone nodes    
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        int start = 0;
        while (start < nodes.size()) {
            UndirectedGraphNode head = nodes.get(start++);
            for (int i = 0; i < head.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = head.neighbors.get(i);
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }

        // clone neighbors
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode newNode = map.get(nodes.get(i));
            for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
                newNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
            }
        }

        return map.get(node);
    }
}