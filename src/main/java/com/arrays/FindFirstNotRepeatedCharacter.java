package com.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNotRepeatedCharacter {

    public static Character solve(String word) {
        if (word == null || word.isEmpty() || word.length()==0) {
            return null;
        }

        char[] chrs = word.toCharArray();
        Map<Character, Integer> maps = new LinkedHashMap<>();
        for (char c:chrs) {
            maps.merge(c, 1, Integer::sum);
        }


        Map.Entry<Character, Integer> r = maps.entrySet().stream().filter(i -> i.getValue() == 1).findFirst().get();

        return r.getKey();
    }

    public static void main(String [] args) {
        System.out.println(solve("esto es una prueba"));
    }

}
