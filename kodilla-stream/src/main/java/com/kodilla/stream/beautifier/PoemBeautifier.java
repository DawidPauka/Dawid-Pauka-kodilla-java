package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String beautyText, PoemDecorator poemDecorator) {
        String textAfterDecoration = poemDecorator.decorate(beautyText);
        System.out.println(textAfterDecoration);

        return beautyText;

    }

    public static class MyBeautyfier1 {
        public static String beauteText(String text){
            return "◘" + "♣" + text + "♣" + "◘";
        }
        public static String beauteText2(String text){
            return "♦" + "☻" + text.toUpperCase() + "☻" + "♦";
        }
    }
}