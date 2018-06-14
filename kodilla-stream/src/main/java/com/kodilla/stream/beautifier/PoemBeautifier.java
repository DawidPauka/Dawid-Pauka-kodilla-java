package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String beautyText, PoemDecorator poemDecorator){
        String textAfterDecoration = poemDecorator.decorate(beautyText);
        System.out.println(textAfterDecoration);

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