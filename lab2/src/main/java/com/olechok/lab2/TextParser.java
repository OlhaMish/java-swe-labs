package com.olechok.lab2;

//Створити клас, який складається з виконавчого методу, що виконує дію з текстовим рядком
//В заданому тексті замінити слова заданої довжини визначеним рядком.
// використовуючи для цього тип даних String.
//Необхідно обробити всі виключні ситуації, що можуть виникнути під час виконання
//програмного коду. Всі змінні повинні бути описані та значення їх задані у виконавчому методі.


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {

    public static String replaceWordsBySizeToRow(String text, int sizeOfWord, String replacement) {
        if (text == null || replacement == null) {
            throw new IllegalArgumentException("The replacement text or string cannot be null\n");
        }
        if (sizeOfWord <= 0) {
            throw new IllegalArgumentException("The word length must be greater than zero\n");
        }

        String result = "";
        Pattern pattern = Pattern.compile("\\p{L}+|\\p{N}+|[^\\p{L}\\p{N}]+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String token = matcher.group();
            if (token.matches("\\p{L}+|\\p{N}+") && token.length() == sizeOfWord) {
                result += replacement;
            } else {
                result += token;
            }
        }
        return result;
    }
}
