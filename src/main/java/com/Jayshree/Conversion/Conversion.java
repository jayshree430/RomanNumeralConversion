package com.Jayshree.Conversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Conversion {

        int getValueForRomanChar(char romanChar) {
            /*
            * Checking roman numerals and passing the associated Value.
            * */
            return switch (romanChar) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> -1;
            };
        }

        int romanToDecimal(String romanString) {

           int result = 0;

            if(romanString == null || romanString.length() == 0) return -1;
            romanString = romanString.toUpperCase();

            //Split the Roman Numeral string into Roman Symbols (character).
            // Convert each symbol of Roman Numerals into the value it represents
            for (int i = 0; i < romanString.length(); i++) {

                int value1 = getValueForRomanChar(romanString.charAt(i));
                if(value1 == -1) return -1;

                if (i + 1 < romanString.length()) {
                    int value2 = getValueForRomanChar(romanString.charAt(i + 1));
                    /*if current value of symbol is greater than or equal to the value
                    of next symbol, then add this value to the running total
                    */
                    if (value1 >= value2) {
                        result += value1;
                    } else {
                       /* else subtract this value by adding the
                       value of next symbol to the running total.
                        */
                        result += value2 - value1;
                        i++;
                    }
                } else {
                    result += value1;
                }
            }
            return result;
        }

    public static void main(String[] args)
            throws IOException
    {
        Conversion convert = new Conversion();
        System.out.println("Roman Numeral Converter");
        System.out.println("Please press enter without any input to exit");
        System.out.println("Please enter a Roman Numeral");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        // Reading data using readLine
        String input = reader.readLine();
        while (input.trim().length() > 0) {
            int result = convert.romanToDecimal(input);
            if (result < 1)
                System.out.println("Invalid input");
            else {
                System.out.println("Integer converted from Roman Numeral is " + result);
            }
            System.out.println("Please enter a Roman Numeral");
            input = reader.readLine();
        }
    }

}
