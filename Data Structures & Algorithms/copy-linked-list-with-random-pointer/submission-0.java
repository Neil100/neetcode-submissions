/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node current = head, previous;
        Node dummy = new Node(0);
        previous = dummy;
        while(current != null) {
            Node newCurrent = new Node(current.val);

            previous.next = newCurrent;
            map.put(current, newCurrent);

            previous = previous.next;
            current = current.next;
        }
        current = head;
        Node newCurrent = dummy.next;

        while(current != null) {
            Node newRandom = map.get(current.random);

            newCurrent.random = newRandom;

            current = current.next;
            newCurrent = newCurrent.next;
        }

        return dummy.next;

    }
}
