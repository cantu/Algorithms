package com.leetcode.tusion.linkedlist;

/**
 * Created by tucan on 15/11/9.
 */
public class LinkedList {

    public ListNode head;

    public  LinkedList(int[] arr){
        int len = arr.length;
        ListNode pre_node;
        ListNode cur_node;
        if( len<=0){
            return;
        }
        cur_node = new ListNode( arr[0]);
        this.head = cur_node;
        pre_node = cur_node;
        //node.val = arr[0];
        for( int i=1; i<len; i++){
            cur_node = new ListNode(arr[i]);
            cur_node.next = null;
            pre_node.next = cur_node;
            pre_node = cur_node;
        }
    }

    public String traverseList(){
        ListNode node;
        StringBuilder sb = new StringBuilder();
        for( node = head; node!=null; node=node.next){
            //System.out.printf("%d, ", node.val);
            sb.append( node.val + ", ");
        }
        return sb.toString();
    }


    public ListNode reverseList(ListNode head) {
        ListNode cur_node=null;
        ListNode pre_node=null;
        ListNode ahead_node=null;

        cur_node = head;
        while( cur_node != null ){
            ahead_node = cur_node.next;
            cur_node.next = pre_node;
            pre_node = cur_node;
            cur_node = ahead_node;
        }
        return pre_node;
    }


    /**
     * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
     *
     * Given a linked list, remove the nth node from the end of list and return its head.
     * For example,
     * Given linked list: 1->2->3->4->5, and n = 2.
     * after removing the second node from the end, the linked list becomes 1->2->3->5.
     * Note:
     * Given n will always be valid.
     * Try to do this in one pass.
     *
     * 用两个相距（n-1）的节点，遍历前面的节点到链表尾巴后，后面的节点直接删除。
     * @param head
     * @param n
     * @return
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ahead_n_node;
        ListNode node;
        int i=0;
        int length=0;
        //list is null
        if(head == null){
            return null;
        }

        for( node=head; node!=null; node=node.next){
            length++;
        }
        if( n>length || n<=0){
            return head;
        }
        if( n==length){
            head = head.next;
            return head;
        }
        for(i=0, ahead_n_node=head; i<=n; i++){
            ahead_n_node = ahead_n_node.next;
        }
        node=head;
        while(ahead_n_node!=null){
            node = node.next;
            ahead_n_node = ahead_n_node.next;
        }
        node.next = node.next.next;

        return head;
    }


    /**
     * https://leetcode.com/problems/remove-linked-list-elements/
     * Remove all elements from a linked list of integers that have value val.
     Example
     Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
     Return: 1 --> 2 --> 3 --> 4 --> 5
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre_node,cur_node;
        if( head == null){
            return null;
        }

        pre_node = null;
        //list head node is the val;
        while( head!=null && head.val == val ){
            head = head.next;
        }
        cur_node=head;
        while( cur_node!=null){
            if( cur_node.val != val){
                pre_node = cur_node;
            }else{
                pre_node.next = cur_node.next;
            }
            cur_node = cur_node.next;
        }
        return head;

    }

    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     For example,
     Given 1->1->2, return 1->2.
     Given 1->1->2->3->3, return 1->2->3.
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur_node, pre_node;

        if(head==null){
            return null;
        }
        pre_node = head;
        cur_node = head.next;
        //pre_val = head.val;
        while( cur_node!=null){
            if( pre_node.val == cur_node.val){
                //delete duplicate node, is curren node;
                pre_node.next = cur_node.next;
            }else{
                pre_node = cur_node;
            }
            cur_node = cur_node.next;
        }

        return head;

    }


    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
     * Given a sorted linked list, delete all nodes that have duplicate numbers,
     * leaving only distinct numbers from the original list.
     For example,
     Given 1->2->3->3->4->4->5, return 1->2->5.
     Given 1->1->1->2->3, return 2->3.
     * @param head
     * @return
     * test case:
     * [1,1] -> []
     * [1,1,2,2]-> []
     * [1,1,2,3,3]->[2]
     */
    public ListNode deleteDuplicates_2(ListNode head) {
        ListNode pre_node, cur_node, ahead_node;
        int dup_val;
        if( head==null){
            return null;
        }
        if( head.next == null){
            return head;
        }

        pre_node = head;
        cur_node = head.next;
        //if head element duplicate
        while( cur_node!=null && pre_node.val == cur_node.val ){
            while( cur_node!=null && cur_node.val==pre_node.val){
                cur_node = cur_node.next;
            }
            //list all is one element, as input[1,1,1], return []
            if( cur_node == null){
                return null;
            }

            pre_node = cur_node;
            cur_node = cur_node.next;
            head = pre_node;
        }

        pre_node = head;
        cur_node = head.next;
        ahead_node = head.next;

        //now list[0], list[1] is not same, process next.
        while( ahead_node!=null ){
            ahead_node = ahead_node.next;
            if( ahead_node!=null && ahead_node.val == cur_node.val){
                while( ahead_node !=null && ahead_node.val == cur_node.val){
                    ahead_node = ahead_node.next;
                }
                pre_node.next = ahead_node;
                cur_node = ahead_node;
            }else{
                pre_node = cur_node;
                cur_node = ahead_node;
            }
        }


        return head;

    }


    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/
     * Merge two sorted linked lists and return it as a new list.
     * The new list should be made by splicing together the nodes of the first two lists.
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1_node, l2_node;
        ListNode min_node;
        ListNode cur_node = null;
        ListNode l3 = null;
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        l1_node = l1;
        l2_node = l2;
        while( l1_node!=null && l2_node!=null){
            if( l1_node.val < l2_node.val){
                min_node = l1_node;
                l1_node = l1_node.next;
            }else{
                min_node = l2_node;
                l2_node = l2_node.next;
            }
            if(l3!=null ) {
                cur_node.next = min_node;
                cur_node = min_node;
            }else{
                //inital list l3 to return.
                l3 = min_node;
                cur_node = min_node;
            }
        }
        //list l2 is empty now
        if( l2_node == null){
            while( l1_node != null ){
                cur_node.next = l1_node;
                cur_node = l1_node;
                l1_node = l1_node.next;
            }
        }
        //list l1 is empty now
        if( l1_node == null ){
            while( l2_node != null){
                cur_node.next = l2_node;
                cur_node = l2_node;
                l2_node =l2_node.next;
            }
        }
        return l3;

    }





    public static void main(){
        System.out.println("main() in LinekdList:");
        //int [] arr5 = {5,4,3,2,1};

    }


    public static String sayHello(){
        return "Hello";
    }
}




