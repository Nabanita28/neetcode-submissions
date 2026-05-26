/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        while ( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode list2 = reverse(slow.next);
        slow.next = null;
        ListNode list1 = head;

        while(list2 != null){
           ListNode tmp1 = list1.next;
           ListNode tmp2 = list2.next;
           list1.next = list2;
           list2.next = tmp1;
           list1 = tmp1;
           list2 = tmp2;
        }

    }

    static ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }
}
