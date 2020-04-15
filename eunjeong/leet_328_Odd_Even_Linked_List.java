/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = null;
        ListNode even = null;
        ListNode evenHead = new ListNode();
        ListNode result = new ListNode();
        
        if(head == null){
            return null;
        }
        
        //  1. odd even list 만들기 
        int count = 1;
        while(head != null){
            //  odd
            if(count % 2 == 1){
                if(odd == null){
                    odd = new ListNode(head.val);
                    result = odd;
                }else{
                    odd.next = new ListNode(head.val);
                    odd = odd.next;
                }
            }
            //  even
            if(count%2 ==0){
                if(even== null){
                    even = new ListNode(head.val);
                    evenHead = even;
                }else{
                    even.next = new ListNode(head.val);
                    even = even.next;
                }
            }
            count++;
            head = head.next;            
        }

        //  리스트 원소 1개일 때도 있음
        if(even != null){
            odd.next = evenHead;
        }
     
        return result;
    }
}



