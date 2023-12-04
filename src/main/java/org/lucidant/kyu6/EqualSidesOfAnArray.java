package org.lucidant.kyu6;

/**
 * @see <a href="https://www.codewars.com/kata/5679aa472b8f57fb8c000047">Source</a>
 * You are going to be given an array of integers. Your job is to take that array and find an index N where the sum of the integers to the left of N is equal
 * to the sum of the integers to the right of N. If there is no index that would make this happen, return -1.
 */
public class EqualSidesOfAnArray {
    public static int findEvenIndex(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(leftSum(arr, i) == rightSum(arr, i))
                return i;
        }

        return -1;
    }

    public static long leftSum(int[] arr,int idx){
        long result = 0;

        for(int i = 0; i < idx; i++){
            result += arr[i];
        }

        return result;
    }

    public static long rightSum(int[] arr, int idx){
        long result = 0;

        for(int i = idx + 1; i < arr.length; i++){
            result += arr[i];
        }

        return result;
    }
}
