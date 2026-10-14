package com.arrays;

public class MergeV1 {

    public static int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null){
            return new int[0];
        }

        if (arr1.length==0 && arr2.length==0){
            return new int[0];
        }

        if (arr1.length==0){
            return arr2;
        }

        if (arr2.length==0){
            return arr1;
        }

        int [] newArray = new int [arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            newArray[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            newArray[arr1.length + i] = arr2[i];
        }

        for (int i = 0; i< newArray.length; i++) {
            for (int j = i + 1; j < newArray.length; j++) {
                if (newArray[i] > newArray[j]) {
                    int x =  newArray[i];
                    newArray[i] = newArray[j];
                    newArray[j] = x;
                }
            }
        }

        return newArray;
    }

    public static int[] solve2(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null){
            return new int[0];
        }

        if (arr1.length==0 && arr2.length==0){
            return new int[0];
        }

        if (arr1.length==0){
            return arr2;
        }

        if (arr2.length==0){
            return arr1;
        }

        int [] newArray = new int [arr1.length + arr2.length];

        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = i+1; j < arr1.length; j++) {
                if (arr2[i] < arr1[j]) {
                    newArray[count] = arr1[j];
                    count++;
                } else {
                    newArray[count] = arr2[i];
                    count++;
                }
            }

            //count++;

        }



        return newArray;
    }

    public static void main(String [] args) {
        int[] arr1 = {2, 3, 9, 10, 20};
        int[] arr2 = {4, 7, 8,10, 59,60};
        int[] mergedArray = solve2(arr1, arr2);

        for (int i = 0; i < mergedArray.length; i++) {
            System.out.print(mergedArray[i] + " ");
        }

        //int[] arr4 = {2, 3, 9, 10, 20};
        //int[] arr5 = {4, 7, 8,10, 59,60};



        //int[] mergedArray2 = merge(null, null);

    }
}
