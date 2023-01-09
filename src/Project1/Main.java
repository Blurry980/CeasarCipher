package Project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static ArrayList<Character> alphabet = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        CeasarCipherArt ca = new CeasarCipherArt();
        String direction;
        String text;
        int shift;
        String goAgain;
        boolean end = false;

        System.out.println();
        System.out.println(ca.logo);
        System.out.println();
        while (!end) {

            System.out.println("Type 'encode' to encrypt, type 'decode' to decrypt:\n");
            direction = scnr.nextLine();

            System.out.println("Type your message:\n");
            text = scnr.nextLine().toLowerCase(Locale.ROOT);

            System.out.println("Type the shift number:\n");
            shift = scnr.nextInt();
            scnr.nextLine();// this consumes the \n which is added when using scnr.nextInt()

            caesar(text, shift, direction);
            System.out.println("Do you want to keep going? Type 'yes' or 'no'. ");
            goAgain = scnr.nextLine();

            if (goAgain.equalsIgnoreCase("no")) {
                end = true;

            }

        }

    }

    private static void caesar(String text, int shift, String direction) {
        String end_text = "";
        if (shift > 26) {
            shift = shift % 26;

        }
        if (direction.equalsIgnoreCase("decode")) {
            shift *= -1;
        }
            for (int i = 0; i <= text.length() - 1; i++) {

                if (!alphabet.contains(text.charAt(i))) {
                    end_text += text.charAt(i);
                } else {
                    int position = alphabet.indexOf(text.charAt(i));
                    int new_position = position + shift;
                    int idx = (alphabet.size() + new_position) % alphabet.size(); //this is how to simulate a negative index

                    end_text += alphabet.get(idx);
                }
            }

        System.out.println("Here's the " + direction + "d result: " + end_text);
    }

}

