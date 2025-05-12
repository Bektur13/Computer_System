package com.bektur;

import java.util.ArrayList;
import java.util.List;

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

            if(Character.isWhitespace(current)) {
                position++;
                continue;
            }

            if(Character.isLetter(current)) {
                tokens.add(readWord());
                continue;
            }

            if(current == '"') {
                tokens.add(readString());
                continue;
            }

            if(Character.isDigit(current)) {
                tokens.add(readNumber());
                continue;
            }

            if(current == '%') {
                tokens.add(new Token(TokenType.SYMBOL, "%"));
                position++;
                continue;
            }

            if(isOperator(current)) {
                tokens.add(new Token(TokenType.OPERATOR, Character.toString(current)));
                position++;
                continue;
            }

            throw new RuntimeException("Unknown character: " + current);
        }

        tokens.add(new Token(TokenType.EOF, ""));
        return tokens;
    }

    private Token readWord() {
        int start = position;
        while(position < input.length() && (Character.isLetterOrDigit(input.charAt(position)) || input.charAt(position) == '_')) {
                position++;
        }
        String word = input.substring(start, position);
        return new Token(TokenType.KEYWORD, word);
    }

    private Token readString() {
        position++;
        int start = position;
        while(position < input.length() && input.charAt(position) != '"') {
            position++;
        }
        String name = input.substring(start, position);
        position++;
        return new Token(TokenType.IDENTIFIER, name);
    }

    private Token readNumber() {
        int start = position;
        while(position < input.length() && (Character.isDigit(input.charAt(position)) || input.charAt(position) == '.'))
        {
            position++;
        }
        String number = input.substring(start, position);
        return new Token(TokenType.NUMBER, number);
    }

    private boolean isOperator(char c) {
        return "=+-*/><".indexOf(c) >= 0;
    }
}
