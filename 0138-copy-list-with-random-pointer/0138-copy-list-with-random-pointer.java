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
        HashMap<Node, Node> copyMap = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            Node copy = new Node(temp.val);
            copyMap.put(temp,copy);
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            Node copy = copyMap.get(temp);
            copy.next = copyMap.get(temp.next);
            copy.random = copyMap.get(temp.random);
            temp = temp.next;
        }
        Node copy = copyMap.get(head);
        return copy;
    }
}