package com.olechok.lab2;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        public static String replaceWordsBySizeToRow(String text, int sizeOfWord, String replacement) {
            String result = "";
            Pattern pattern = Pattern.compile("\\p{L}+|\\p{N}+|[^\\p{L}\\p{N}]+");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                String token = matcher.group();
                if (token.matches("\\p{L}+|\\p{N}+") && token.length() == sizeOfWord) {
                    result = result.concat(replacement);
                } else {
                    result = result.concat(token);
                }
            }
            return result;
        }
    }
