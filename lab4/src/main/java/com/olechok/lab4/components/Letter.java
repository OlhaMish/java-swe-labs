package com.olechok.lab4.components;

public record Letter(char letter) {

    @Override
    public String toString() {
        return Character.toString(letter);
    }

}
