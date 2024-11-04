package com.olechok.lab2;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter text: ");
            String text = scanner.nextLine();

            System.out.print("Enter the length of the words to replace: ");
            int targetLength = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter a string to replace: ");
            String replacement = scanner.nextLine();

            String result = TextParser.replaceWordsBySizeToRow(text, targetLength, replacement);
            System.out.println("Result: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Error: Word length must be a number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unknown error: " + e.getMessage());
        }
    }

}



