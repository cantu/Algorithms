package com.tusion.algorithm.sorting;

import java.util.Arrays;
import java.lang.Comparable;

/**
 * Created by tucan on 15/11/2.
 */
public class SelectSorting {

    public static void sort(Comparable[] arr){
        int len = arr.length;
        for( int i=0; i<len; i++){
            int min_index = i;
            for( int j=i+1; j<len; j++){
                if( less(arr[j], arr[min_index] )){
                    min_index = j;
                }
                if(min_index!=i){
                    swap( arr, i, min_index);
                    ;
                }
            }
        }
    }



    private static boolean less( Comparable v, Comparable w){
        return (v.compareTo( w ) < 0);
    }

    private static void swap( Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private static boolean isSorted( Comparable[] arr){
        for( int i=1; i<arr.length; i++){
            if( less( arr[i], arr[i-1])){
                return false;
            }
        }
        return true;
    }



    private static void printArray( Comparable[] arr){
        System.out.print("Print array: ");
        Comparable t;

        for( Comparable e : arr){
            System.out.print( e + ", ");
        }
        /*
        for( int i=0; i<arr.length; i++){
            System.out.print( arr[i] + " ");
        }
        */
        System.out.println();
    }


    public static void main( String[] args){
        Comparable [] test_array = {9,8,7,6,5,4,3,2,1};
        printArray(test_array);
        sort( test_array);
        assert isSorted( test_array):"Sort failed.";
        printArray(test_array);

    }
}
