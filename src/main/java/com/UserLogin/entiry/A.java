package com.UserLogin.entiry;

import java.util.Arrays;
import java.util.stream.IntStream;

public class A {
   // 1. Sort this array using merge sort. [1, 2, 8, 9, 3, 11, 5, 4]

    public static void main(String[] args) {
        int[] arr = {1,2,8,9,3,11,5,4};
        int[] array = Arrays.stream(arr).sorted().toArray();
        for (int i : array) {
            System.out.println(i);

        }
    }
}
