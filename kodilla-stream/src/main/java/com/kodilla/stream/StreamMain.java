package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;



public class StreamMain {

    public static void main(String[] args) {
        System.out.println("WE START!" );

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        // Expression with method reference
        poemBeautifier.beautify("Java", String::toUpperCase);
        poemBeautifier.beautify("Test Programming", PoemBeautifier.MyBeautyfier1::beauteText);
        poemBeautifier.beautify("SOFTWARE IS GOOD", String::toLowerCase);
        poemBeautifier.beautify("ABC", PoemBeautifier.MyBeautyfier1::beauteText2);
    }
}
