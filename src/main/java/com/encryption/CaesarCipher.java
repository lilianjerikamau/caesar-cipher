package com.encryption;
import java.util.Scanner;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class CaesarCipher {
    public static void main(String[] args){
        System.out.print("Caesar Cipher Number: ");
        Scanner number = new Scanner(System.in);
        int cipherNumber = number.nextInt(); //takes user input
        System.out.print("Enter text to cipher: ");
        Scanner text = new Scanner(System.in);
        String userInput = text.nextLine();

        System.out.println(cipher(userInput,cipherNumber));

    }
    private static final int SIZE_OF_ALPHABET = 26;

    public  static String cipher(String text, int rotateBy) {

        // rotate by only the size of the alphabet:
        rotateBy %= SIZE_OF_ALPHABET;
        char[] chars = text.toCharArray();
        rotate(chars, rotateBy);
        return new String(chars);
    }
    private static void rotate(char[] chars, int rotateBy) {
        for (int i = 0; i < chars.length; ++i) {
            if (isLowerCase(chars[i])) {
                chars[i] = rotateChar(chars[i], rotateBy, 'a', 'z');
            } else if (isUpperCase(chars[i])) {
                chars[i] = rotateChar(chars[i], rotateBy, 'A', 'Z');
            }
        }
    }

    private static char rotateChar(char a, int rotateBy, char firstChar, char lastChar) {
        a += rotateBy;
        // check lower bounds for left rotation:
        if (a < firstChar) {
            return (char) (a + SIZE_OF_ALPHABET);
        }
        // check upper bounds for right rotation:
        if (a > lastChar) {
            return (char) (a - SIZE_OF_ALPHABET);
        }
        // this one is within alphabet bounds:
        return a;
    }



}



