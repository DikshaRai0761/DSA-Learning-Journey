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
    public ListNode rotateRight(ListNode head, int k) {
       if(head==null || head.next==null){
        return head;
       } 
       ListNode tail=head;
       int length=1;
       while(tail.next!=null){
        tail=tail.next;
        length++;
       }
       k=k%length;
       if(k==0){
        return head;
       }
       ListNode newLast= head;
       for(int i=1; i<length-k; i++){
        newLast=newLast.next;
       }
       ListNode newHead=newLast.next;
       tail.next=head;
       newLast.next=null;
       return newHead;
    }
}