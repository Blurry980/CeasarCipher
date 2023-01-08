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
        // write your code here

        Scanner scnr = new Scanner(System.in);
        String direction;
        String text;
        int shift;
        String goAgain;
//symbols = ['!','@','#','$','%','^','&','*','(',')','_','+','-','~','=']

        boolean end = false;
        //print(art.logo)
        while (!end) {

            System.out.println("Type 'encode' to encrypt, type 'decode' to decrypt:\n");
            direction = scnr.nextLine();
            //System.out.println(direction);

            System.out.println("Type your message:\n");
            text = scnr.nextLine().toLowerCase(Locale.ROOT);


            System.out.println("Type the shift number:\n");
            shift = scnr.nextInt();
            scnr.nextLine();// this consumes the \n which is added when using scnr.nextInt()

            //System.out.println(direction + text + shift);


            caesar(text, shift, direction);
            System.out.println("Do you want to keep going? Type 'yes' or 'no'. ");
            //System.out.println("Print me ");
            goAgain = scnr.nextLine();
            //System.out.println("Print me too");

            if (goAgain.equalsIgnoreCase("no")) {
                //System.out.println("It was a no");
                end = true;

            }

        }

        /* def caesar(start_text, shift_amount, cipher_direction):




         */
    }

    private static void caesar(String text, int shift, String direction) {
        String end_text = "";
        if (shift > 26) {
            shift = shift % 26;

        }
        if (direction.equalsIgnoreCase("decode")) {
            shift *= -1;
            for (int i = 0; i >= text.length() - 1; i++) {

                if (!alphabet.contains(text.charAt(i))) {
                    end_text += text.charAt(i);
                } else {
                    int position = alphabet.indexOf(text.charAt(i));
                    int new_position = position + shift;
                    end_text += alphabet.get(new_position);
                    System.out.println(alphabet.get(new_position));
                }
            }
        }
        System.out.println("Here's the " + direction + "d result: " + end_text);
    }

}

