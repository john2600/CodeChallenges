package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class CountRepeatedChar {

    public static Map<Character, Integer> countOcurrences(char [] chrs) {
        if (chrs==null || chrs.length==0) {
            return new HashMap<>();
        }

        Map<Character, Integer> maps = new HashMap<>();

        /*
        for (int i=0; i<chrs.length; i++) {
                if (!maps.containsKey(chrs[i])) {
                    maps.put(chrs[i], 1);
                } else {
                    maps.put(chrs[i], maps.get(chrs[i]) + 1);
                }
        }
        */

        for (char i : chrs) {
            maps.put(i, maps.getOrDefault(i, 0) + 1);
        }

        //maps.entrySet().removeIf(e-> e.getValue()<2 );
        maps.values().removeIf(e-> e<2 );
        return maps;
    }

    public static Map<Character, Integer> countRepeatedV3(char [] chrs) {
        Map<Character, Integer> maps = new HashMap<>();

        for (int i=0; i<chrs.length; i++) {
            if (!maps.containsKey(chrs[i])) {
                maps.put(chrs[i], 1);
            } else {
                maps.put(chrs[i], maps.get(chrs[i]) + 1);
            }
        }

        return maps.entrySet().stream().filter(i->i.getValue()>=2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


    public static Map<Character, Long> countRepeatedV2(Character [] chrs) {
        return Arrays.stream(chrs).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main (String [] args){
        char[] ch = new char[]{'a','x','b','e','a', 'x', 'a'};
        // System.out.println(countRepeated(ch));

        //Character[] ch = new Character[]{'a','x','b','e','a', 'x', 'a'};
        System.out.println(countOcurrences(ch));
    }
}
