package com.leetcode.tusion.linkedlist;

import junit.framework.TestCase;

/**
 * Created by tucan on 15/11/9.
 */
public class LinkedListTest extends TestCase {
    private LinkedList List_0;
    private LinkedList List_1;
    private LinkedList List_2;
    private LinkedList List_3;
    private LinkedList List_4;
    private LinkedList List_5;
    private LinkedList List_6;
    private LinkedList List_7;
    private LinkedList List_8;
    private LinkedList result_list;

    public void setUp() throws Exception {
        super.setUp();

        int [] arr0 ={};
        int [] arr1 = {1};
        int [] arr2 = {2};
        int [] arr3 = {1,2};
        int [] arr4 = {1,2,3,4,5};
        int [] arr5 = {5,4,3,2,1};
        int [] arr6 = {4,7};
        int [] arr7 = {1,1,9,9};
        int [] arr8 = {1,1,1,9};


        List_0 = new LinkedList(arr0);
        List_1 = new LinkedList(arr1);
        List_2 = new LinkedList(arr2);
        List_3 = new LinkedList(arr3);
        List_4 = new LinkedList(arr4);
        List_5 = new LinkedList(arr5);
        List_6 = new LinkedList(arr6);
        List_7 = new LinkedList(arr7);
        List_8 = new LinkedList(arr8);

        result_list = new LinkedList(arr0);

    }

    public void tearDown() throws Exception {

    }

    public void testSayHello() throws Exception {
        assertEquals("Hello", LinkedList.sayHello());
    }

    public void testTraverseList() throws Exception {
        assertEquals("1, 2, 3, 4, 5, ", List_4.traverseList());
    }

    public void testReverseList() throws Exception {
        List_4.head  = List_4.reverseList( List_4.head);
        assert List_4!=null : "Reverse failed!";
        String result =  List_4.traverseList();
        System.out.println( result );
        assertEquals( "5, 4, 3, 2, 1, ", result );

        List_2.head = List_2.reverseList(List_2.head);
        result =  List_2.traverseList();
        System.out.println( result );
        assertEquals( "2, ", result );

    }


    public void testMergeTwoLists() throws Exception{
        String result;
        System.out.println("Test Merge two sorted list:");

        //test l1, l2 has not union
        this.result_list.head =  List_0.mergeTwoLists(List_3.head, List_6.head);
        result = result_list.traverseList();
        System.out.println( result );
        assertEquals("1, 2, 4, 7, ", result_list.traverseList());



        //test l1 is null;
        this.result_list.head = List_0.mergeTwoLists( List_0.head, List_6.head);
        result = result_list.traverseList();
        System.out.println( result );
        assertEquals("4, 7, ", result_list.traverseList());


        //test l2 is null;
        this.result_list.head = List_0.mergeTwoLists( List_6.head, List_0.head);
        result = result_list.traverseList();
        System.out.println( result );
        assertEquals("4, 7, ", result_list.traverseList());

        this.result_list.head =  List_0.mergeTwoLists(List_4.head, List_6.head);
        result = result_list.traverseList();
        System.out.println( result );
        assertEquals("1, 2, 3, 4, 4, 5, 7, ", result_list.traverseList());



    }

    public void testRemoveNthFromEnd() throws Exception {
        String result;
        System.out.println("Test remove Nth from end of list");

        //test last 2 position
        System.out.println("raw array: "+ this.List_4.traverseList()+"; n=2" );
        this.List_4.head = this.List_0.removeNthFromEnd( this.List_4.head, 2);
        result = this.List_4.traverseList();
        System.out.println( "result: " + result );
        assertEquals("1, 2, 3, 5, ", result);

        //test last 1 position
        System.out.println("raw array: "+ this.List_4.traverseList()+"; n=1"  );
        this.List_4.head = this.List_0.removeNthFromEnd( this.List_4.head, 1);
        result = this.List_4.traverseList();
        System.out.println( "result: " + result );
        assertEquals("1, 2, 3, ", result);

        //test first position
        System.out.println("raw array: "+ this.List_4.traverseList() +"; n=3" );
        this.List_4.head = this.List_4.removeNthFromEnd( this.List_4.head, 3);
        result = this.List_4.traverseList();
        System.out.println( "result: " + result );
        assertEquals("2, 3, ", result);

        //test first position
        System.out.println("raw array: "+ this.List_2.traverseList() +"; n=1" );
        this.List_2.head = this.List_2.removeNthFromEnd( this.List_2.head, 1);
        result = this.List_2.traverseList();
        System.out.println( "result: " + result );
        assertEquals("", result);

    }

    public void testRemoveElements() throws Exception{
        String result;
        System.out.println("Test remove element from  list");

        //test remove 1 element in middle
        System.out.println("raw array: "+ this.List_4.traverseList()+"; val=2" );
        this.List_4.head = this.List_4.removeElements(this.List_4.head, 2);
        result = this.List_4.traverseList();
        System.out.println( "result: " + result );
        assertEquals("1, 3, 4, 5, ", result);

        //test remove 1 element at begin
        System.out.println("raw array: "+ this.List_4.traverseList()+"; val=1" );
        this.List_4.head = this.List_4.removeElements( this.List_4.head, 1);
        result = this.List_4.traverseList();
        System.out.println( "result: " + result );
        assertEquals("3, 4, 5, ", result);

        //test remove 1 element at end of list
        System.out.println("raw array: "+ this.List_4.traverseList()+"; val=5" );
        this.List_4.head = this.List_4.removeElements( this.List_4.head, 5);
        result = this.List_4.traverseList();
        System.out.println( "result: " + result );
        assertEquals("3, 4, ", result);

        //test remove many element at begin
        System.out.println("raw array: "+ this.List_7.traverseList()+"; val=1" );
        this.List_7.head = this.List_7.removeElements( this.List_7.head, 1);
        result = this.List_7.traverseList();
        System.out.println( "result: " + result );
        assertEquals("9, 9, ", result);

        //test remove many element at begin
        System.out.println("raw array: "+ this.List_1.traverseList()+"; val=1" );
        this.List_1.head = this.List_1.removeElements( this.List_1.head, 1);
        result = this.List_1.traverseList();
        System.out.println( "result: " + result );
        assertEquals("", result);
    }


    public void testDeleteDuplicates() throws Exception{
        String result;
        System.out.println("Test remove duplicate elements from  list");

        //test remove many element at begin
        System.out.println("raw array: "+ this.List_7.traverseList() );
        this.List_7.head = this.List_7.deleteDuplicates( this.List_7.head);
        result = this.List_7.traverseList();
        System.out.println( "result: " + result );
        assertEquals("1, 9, ", result);
    }

    /**
     * * test case:
     * [1,1] -> []
     * [1,1,2,2]-> []
     * [1,1,2,3,3]->[2]
     * @throws Exception
     */
    public void testDeleteDuplicates_2() throws Exception{
        String result;
        System.out.println("Test remove all duplicate elements from  list");

        //test remove many element at begin and end
        System.out.println("raw array: "+ this.List_7.traverseList() );
        this.List_7.head = this.List_7.deleteDuplicates_2(this.List_7.head);
        result = this.List_7.traverseList();
        System.out.println( "result: " + result );
        assertEquals("", result);

        //test remove many element at begin
        System.out.println("raw array: "+ this.List_8.traverseList() );
        this.List_8.head = this.List_8.deleteDuplicates_2(this.List_8.head);
        result = this.List_8.traverseList();
        System.out.println( "result: " + result );
        assertEquals("9, ", result);


        //test remove nothing
        System.out.println("raw array: "+ this.List_3.traverseList() );
        this.List_3.head = this.List_3.deleteDuplicates_2(this.List_3.head);
        result = this.List_3.traverseList();
        System.out.println( "result: " + result );
        assertEquals("1, 2, ", result);


    }
}