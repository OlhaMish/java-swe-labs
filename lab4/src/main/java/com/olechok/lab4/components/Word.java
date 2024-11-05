package com.olechok.lab4.components;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private final List<Letter> letters;

    public Word(String word) {
        letters = new ArrayList<>();
        for (char ch : word.toCharArray()) {
            letters.add(new Letter(ch));
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Letter letter : letters) {
            result.append(letter.letter());
        }
        return result.toString();
    }
}
