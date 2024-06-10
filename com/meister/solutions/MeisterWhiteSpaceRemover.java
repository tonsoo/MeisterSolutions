package com.meister.solutions;

public class MeisterWhiteSpaceRemover {

    public static String RemoveWhiteSpace(String input) {
        String fixedInput = "";

        for(int i = 0; i < input.length(); i++){
            char currentChar = input.charAt(i);
            if(currentChar == ' '){
                continue;
            }

            fixedInput += currentChar;
        }

        return fixedInput;
    }
}
