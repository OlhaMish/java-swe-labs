package com.olechok.lab2;

//Створити клас, який складається з виконавчого методу, що виконує дію з текстовим рядком
//В заданому тексті замінити слова заданої довжини визначеним рядком.
// використовуючи для цього тип даних String.
//Необхідно обробити всі виключні ситуації, що можуть виникнути під час виконання
//програмного коду. Всі змінні повинні бути описані та значення їх задані у виконавчому методі.


public class TextParser {

    public static String replaceWordsBySizeToRow(String text, int SizeOfWord, String replacement) {
        if (text == null || replacement == null) {
            throw new IllegalArgumentException("The replacement text or string cannot be null\n");
        }
        if (SizeOfWord <= 0) {
            throw new IllegalArgumentException("The word length must be greater than zero\n");
        }
        String[] arrayOfWords = text.split("[^\\p{L}\\p{N}]+");
        String processedArrayOfWords = "";

        for (String word : arrayOfWords){
            if (word.length() == SizeOfWord){
                word = replacement;
            }
            processedArrayOfWords += " " + word;
        }
        return processedArrayOfWords;
    }
}
