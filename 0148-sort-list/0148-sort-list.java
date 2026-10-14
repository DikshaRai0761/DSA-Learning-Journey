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
    public ListNode sortList(ListNode head) {
      ArrayList<Integer> arr=new ArrayList<>();
      ListNode temp=head;
      while(temp!=null){
        arr.add(temp.val);
        temp=temp.next;
      }
Collections.sort(arr);
ListNode dummy=new ListNode(0);
temp=dummy;
for(int num:arr){
    temp.next=new ListNode(num);
    temp=temp.next;
}
return dummy.next;
    }
}