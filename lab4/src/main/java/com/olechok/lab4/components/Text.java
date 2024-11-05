package com.olechok.lab4.components;
import java.util.ArrayList;
import java.util.List;

public class Text {
    private final List<Sentence> sentences;

    public Text(String text) {
        sentences = new ArrayList<>();
        String[] sentencesArray = text.split("(?<=[.!?])\\s+");
        for (String sentence : sentencesArray) {
            sentences.add(new Sentence(sentence.trim()));
        }
    }

    @Override
    public String toString() {
        List<String> parts = new ArrayList<>();

        for (Sentence sentence : sentences) {
            parts.add(sentence.toString());
        }

        return String.join(" ", parts).trim();
    }

    public void replaceWordsOfLength(int length, String replacement) {
        for (Sentence sentence : sentences) {
            sentence.replaceWordsOfLengthInSentence(length, replacement);
        }
    }
}
