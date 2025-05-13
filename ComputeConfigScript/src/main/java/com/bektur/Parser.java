package com.bektur;

import java.util.*;

import static com.bektur.Main.processLine;

public class Parser {
    private final List<Token> tokens;
    private int position = 0;
    private final Map<String, Double> configs;

    public Parser(List<Token> tokens, Map<String, Double> configs) {
        this.tokens = tokens;
        this.configs = configs;
    }

    private Token current() {
        return tokens.get(position);
    }

    private Token next() {
        if(position >= tokens.size()) {
            return new Token(TokenType.EOF, "");
        }
        return tokens.get(position++);
    }

    public void parse() {
        while(position < tokens.size()) {
            Token token = current();
            if(token.type == TokenType.KEYWORD && token.value.equals("loop")) {
                parseLoop();
            } else {
                StringBuilder line = new StringBuilder();
                while (position < tokens.size()) {
                    Token t = current();

                    if (t.type == TokenType.KEYWORD && t.value.equals("end")) {
                        break;
                    }

                    line.append(t.value).append(" ");
                    next();
                }

                processLine(line.toString().trim(), configs);
            }
            if(current().type != TokenType.EOF) next();
        }
    }

    public void parseLoop() {
        next();
        String loopVar = next().value;

        next();
        int from = Integer.parseInt(next().value);

        next();
        int to = Integer.parseInt(next().value);

        List<Token> body = new ArrayList<>();

        while( !(current().type == TokenType.KEYWORD && current().value.equals("end"))) {
            body.add(next());
        }

        for(int i = from; i <= to; i++) {
            StringBuilder line = new StringBuilder();
            for(Token token : body) {
                if(token.type == TokenType.IDENTIFIER) {
                    String replaced = token.value.replace("%" + loopVar, Integer.toString(i));
                    line.append("\"").append(replaced).append("\" ");
                } else {
                    line.append(token.value).append(" ");
                }
            }
            processLine(line.toString().trim(), configs);
        }
        next();
    }
}
