package com.olechok.lab4;
import com.olechok.lab4.components.Text;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String text = scanner.nextLine();

            System.out.print("Enter the length of the words to replace: ");
            int sizeOfWord = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter a string to replace: ");
            String replacement = scanner.nextLine();

            if (text == null || replacement == null) {
                throw new IllegalArgumentException("The replacement text or string cannot be null\n");
            }
            if (sizeOfWord <= 0) {
                throw new IllegalArgumentException("The word length must be greater than zero\n");
            }

            String result = replaceWordsBySizeToRow(text, sizeOfWord, replacement);
            System.out.println("Result: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Error: Word length must be a number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unknown error: " + e.getMessage());
        }
    }

    public static String replaceWordsBySizeToRow(String inputText, int sizeOfWord, String replacement) {
        String normalizedText = inputText.replaceAll("[\\t\\s]+", " ").trim();
        Text text = new Text(normalizedText);

        text.replaceWordsOfLength(sizeOfWord, replacement);

        return text.toString();
    }
}
