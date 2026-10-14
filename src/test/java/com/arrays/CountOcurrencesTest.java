package com.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CountOcurrencesTest {

    @Test
    @DisplayName("null input returns an empty map")
    void nullInputReturnsEmptyMap() {
        Map<Character, Integer> result = CountRepeatedChar.countOcurrences(null);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("empty array returns an empty map")
    void emptyArrayReturnsEmptyMap() {
        Map<Character, Integer> result = CountRepeatedChar.countOcurrences(new char[]{});

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("single character is not repeated, so the map is empty")
    void singleCharacter() {
        Map<Character, Integer> result = CountRepeatedChar.countOcurrences(new char[]{'a'});

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("all distinct characters return an empty map")
    void allDistinctCharacters() {
        Map<Character, Integer> result = CountRepeatedChar.countOcurrences(new char[]{'a', 'b', 'c'});

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("character appearing exactly twice is included")
    void exactlyTwiceIsIncluded() {
        Map<Character, Integer> result = CountRepeatedChar.countOcurrences(new char[]{'a', 'b', 'a'});

        assertEquals(Map.of('a', 2), result);
    }

    @Test
    @DisplayName("same character repeated is counted correctly")
    void allSameCharacter() {
        Map<Character, Integer> result = CountRepeatedChar.countOcurrences(new char[]{'z', 'z', 'z', 'z'});

        assertEquals(Map.of('z', 4), result);
    }

    @Test
    @DisplayName("only repeated characters are returned from a mixed array")
    void mixedCharacters() {
        char[] input = {'a', 'x', 'b', 'e', 'a', 'x', 'a'};

        Map<Character, Integer> result = CountRepeatedChar.countOcurrences(input);

        assertEquals(Map.of('a', 3, 'x', 2), result);
    }

    @Test
    @DisplayName("upper and lower case are treated as different characters")
    void caseSensitive() {
        Map<Character, Integer> result = CountRepeatedChar.countOcurrences(new char[]{'a', 'A', 'a'});

        assertEquals(Map.of('a', 2), result);
    }

    @Test
    @DisplayName("digits, whitespace and symbols are counted")
    void nonLetterCharacters() {
        Map<Character, Integer> result = CountRepeatedChar.countOcurrences(new char[]{' ', '1', ' ', '!', '1', ' '});

        assertEquals(Map.of(' ', 3, '1', 2), result);
    }

    @Test
    @DisplayName("unicode characters are counted")
    void unicodeCharacters() {
        Map<Character, Integer> result = CountRepeatedChar.countOcurrences(new char[]{'ñ', 'é', 'ñ'});

        assertEquals(Map.of('ñ', 2), result);
    }

    @Test
    @DisplayName("input array is not modified")
    void inputNotModified() {
        char[] input = {'b', 'a', 'b'};

        CountRepeatedChar.countOcurrences(input);

        assertEquals("bab", new String(input));
    }

    @Test
    @DisplayName("large input is counted correctly")
    void largeInput() {
        char[] input = new char[100_001];
        for (int i = 0; i < 100_000; i++) {
            input[i] = (i % 2 == 0) ? 'a' : 'b';
        }
        input[100_000] = 'c';

        Map<Character, Integer> result = CountRepeatedChar.countOcurrences(input);

        assertEquals(Map.of('a', 50_000, 'b', 50_000), result);
    }
}
