package com.bektur;


// x = 3 + 5 * 6
// y = x - 2;
// if(x < 0) {
//    y = 1;
//}

public class Lexer {
    private static final char EDF_CHAR = '\0';
    private final String input;
    private int position;
    private char currentChar;

    public Lexer(String input) {
        this.input = input;
        this.position = 0;
        this.currentChar = input == null || input.isEmpty()  ? EDF_CHAR : input.charAt(position);
    }

    public static class Token {
        public final TokenType tokenType;
        public final String value;

    public Token nextToken() {
        while(currentChar != EDF_CHAR) {
            if(Character.isWhitespace(currentChar)){
                skipWhitespace();
                continue;
            }
        }
        return null;
    }

    private void skipWhitespace() {
        while(Character.isWhitespace(curentChar)) {
            advance();

        }
    }

        private void advance() {
            position++;
            currentChar
        }

        public Token(TokenType tokenType, String value)
        {
            this.tokenType = tokenType;
            this.value = value;
        }    }

    public enum TokenType {
        NUMBER, IDENTIFIER, PLUS
    }

}
