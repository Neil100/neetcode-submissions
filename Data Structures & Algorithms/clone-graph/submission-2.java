/*
Definition for a Node.
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
*/

class Solution {
    Map<Integer, Node> dictionary;
    public Node cloneGraph(Node node) {
        dictionary = new HashMap<>();
        if(node==null)
            return null;
        
        Node baseNode = new Node(node.val);
        dictionary.put(node.val, baseNode);
        cloneNode(node);
        return baseNode;
    }

    void cloneNode(Node node) {

        List<Node> neighbors = node.neighbors;
        Node newNode = dictionary.get(node.val);
        for(Node nNode : neighbors) {
            Node newNNode;
            if(dictionary.containsKey(nNode.val)) {
                newNNode = dictionary.get(nNode.val);
                newNode.neighbors.add(newNNode);
            } else {
                newNNode = new Node(nNode.val);
                newNode.neighbors.add(newNNode);
                dictionary.put(nNode.val, newNNode);
                cloneNode(nNode);
            }
        }
    }
}