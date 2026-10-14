package com.arguments;

public class ArgumentsV1 {
    public static void printNames(String... names) {
        for (String name : names) {
            System.out.println(name);
        }

    }

    public static void main(String [] args){
        printNames("a", "b", "c");
        printNames();
    }
}
