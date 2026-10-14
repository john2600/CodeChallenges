package com.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CountRepeatedCharTest {

    @Test
    @DisplayName("null input returns an empty map")
    void nullInputReturnsEmptyMap() {
        Map<Character, Integer> result = CountRepeatedChar.countRepeatedV3(null);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("empty array returns an empty map")
    void emptyArrayReturnsEmptyMap() {
        Map<Character, Integer> result = CountRepeatedChar.countRepeatedV3(new char[]{});

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("single character is counted once")
    void singleCharacter() {
        Map<Character, Integer> result = CountRepeatedChar.countRepeatedV3(new char[]{'a'});

        assertEquals(Map.of('a', 1), result);
    }

    @Test
    @DisplayName("same character repeated is counted correctly")
    void allSameCharacter() {
        Map<Character, Integer> result = CountRepeatedChar.countRepeatedV3(new char[]{'z', 'z', 'z', 'z'});

        assertEquals(Map.of('z', 4), result);
    }

    @Test
    @DisplayName("counts occurrences of each character in a mixed array")
    void mixedCharacters() {
        char[] input = {'a', 'x', 'b', 'e', 'a', 'x', 'a'};

        Map<Character, Integer> result = CountRepeatedChar.countRepeatedV3(input);

        assertEquals(Map.of('a', 3, 'x', 2, 'b', 1, 'e', 1), result);
    }

    @Test
    @DisplayName("all distinct characters each have a count of one")
    void allDistinctCharacters() {
        Map<Character, Integer> result = CountRepeatedChar.countRepeatedV3(new char[]{'a', 'b', 'c'});

        assertEquals(Map.of('a', 1, 'b', 1, 'c', 1), result);
    }

    @Test
    @DisplayName("upper and lower case are treated as different characters")
    void caseSensitive() {
        Map<Character, Integer> result = CountRepeatedChar.countRepeatedV3(new char[]{'a', 'A', 'a'});

        assertEquals(Map.of('a', 2, 'A', 1), result);
    }

    @Test
    @DisplayName("digits, whitespace and symbols are counted")
    void nonLetterCharacters() {
        Map<Character, Integer> result = CountRepeatedChar.countRepeatedV3(new char[]{' ', '1', ' ', '!', '1', ' '});

        assertEquals(Map.of(' ', 3, '1', 2, '!', 1), result);
    }

    @Test
    @DisplayName("unicode characters are counted")
    void unicodeCharacters() {
        Map<Character, Integer> result = CountRepeatedChar.countRepeatedV3(new char[]{'ñ', 'é', 'ñ'});

        assertEquals(Map.of('ñ', 2, 'é', 1), result);
    }

    @Test
    @DisplayName("input array is not modified")
    void inputNotModified() {
        char[] input = {'b', 'a', 'b'};

        CountRepeatedChar.countRepeatedV3(input);

        assertEquals("bab", new String(input));
    }

    @Test
    @DisplayName("large input is counted correctly")
    void largeInput() {
        char[] input = new char[100_000];
        for (int i = 0; i < input.length; i++) {
            input[i] = (i % 2 == 0) ? 'a' : 'b';
        }

        Map<Character, Integer> result = CountRepeatedChar.countRepeatedV3(input);

        assertEquals(Map.of('a', 50_000, 'b', 50_000), result);
    }

    /*
    @Test
    @DisplayName("only characters that repeat (count > 1) are returned")
    void onlyRepeatedCharactersReturned() {
        char[] input = {'a', 'x', 'b', 'e', 'a', 'x', 'a'};

        Map<Character, Integer> result = CountRepeatedChar.countRepeated(input);

        assertEquals(Map.of('a', 3, 'x', 2), result);
    }
     */
}
