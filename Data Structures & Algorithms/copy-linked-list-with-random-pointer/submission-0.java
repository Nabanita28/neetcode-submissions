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

        if(head == null){
            return null;
        }
        
        Node curr = head;

        while(curr != null){
           Node tmp = new Node(curr.val);
           tmp.next = curr.next;
           curr.next = tmp;
           curr = tmp.next;
        }

        Node l1 = head;
       Node newHead = head.next;

        while(l1 != null){
            if(l1.random != null){
                l1.next.random = l1.random.next;
            }
            l1 = l1.next.next;

        }

        l1 = head;
        

        while(l1 != null){
            Node l2 = l1.next;
            l1.next = l2.next;
            if(l2.next != null){
                l2.next = l2.next.next;
            }
            
            l1 = l1.next;
        }

return newHead;

    }
}
