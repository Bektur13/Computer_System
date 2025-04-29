package com.bektur;

import java.util.ArrayList;

public class Lexer {
    private final String input;
    private int position = 0;

    public Lexer(String input) {
        this.input = input;
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();

        while(position < input.length()) {
            char current = input.charAt(position);

            if(Character.isLetter(current)) {
                tokens.add(readWord());
            }
        }
        return tokens;
    }

    public Token readWord() {
        int start = position;

        while(position < input.length()) {
            if(Character.isLetter(input.charAt(position)) || input.charAt(position) == "_") {
                position++;
            }
            String word = input.substring(start, position);
            return new Token(TokenType.KEYWORD, word);
        }
    }
}
