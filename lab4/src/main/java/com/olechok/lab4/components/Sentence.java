package com.olechok.lab4.components;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
    private final List<Object> elements;

    public Sentence(String sentence) {
        elements = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\p{L}+|\\p{N}++|\\p{Punct}");
        Matcher matcher = pattern.matcher(sentence);

        while (matcher.find()) {
            String element = matcher.group();

            if (Pattern.matches("\\p{L}+|\\p{N}+", element)) {
                elements.add(new Word(element));  // Додаємо як слово
            } else {
                elements.add(new Punctuation(element.charAt(0)));  // Додаємо як розділовий знак
            }
        }
    }

    public String toString() {
        List<String> parts = new ArrayList<>();

        for (Object element : elements) {
            if (element instanceof Word) {
                parts.add(" " + element);
            } else if (element instanceof Punctuation) {
                parts.add(element.toString());
            }
        }

        return String.join("", parts).trim();
    }

    public void replaceWordsOfLengthInSentence(int length, String replacement) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) instanceof Word word) {
                if (word.toString().length() == length) {
                    elements.set(i, new Word(replacement));
                }
            }
        }
    }
}
