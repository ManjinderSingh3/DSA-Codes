package main.java;
import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class b_CloneGraph {
    private Node helper(Node originalNode, Map<Node, Node> map){
        Node newNode = new Node(originalNode.val);
        map.put(originalNode, newNode);
        for(Node neighbor : originalNode.neighbors){
            if(!map.containsKey(neighbor)){
                newNode.neighbors.add(helper(neighbor, map));
            }else{
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        Map<Node, Node> map = new HashMap();
        return helper(node, map);
    }
}
