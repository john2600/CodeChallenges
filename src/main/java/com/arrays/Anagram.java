package com.arrays;

import java.util.Arrays;

public class Anagram {

    public static boolean isAnagram(char[] chars1, char[] chars2) {
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    public static boolean isPalindrom(String word) {
        char [] wds = word.toCharArray();
        int i=0;
        int e= wds.length-1;
        while (i<e) {
            if (wds[i]!=wds[e]){
                return false;
            }
            i++;
            e--;
        }
        return true;

    }

    public static void main(String[] args) {
        char[] chars1 = {'a', 'b', 'c'};
        char[] chars2 = {'b', 'a', 'c'};

        boolean result = isAnagram(chars1, chars2);
        System.out.println("Are the two character arrays anagrams? " + result);

        "pepe".toCharArray();

        boolean r = isPalindrom("lateleletal");
        System.out.println("Is the word a palindrome? " + r);
    }
}
