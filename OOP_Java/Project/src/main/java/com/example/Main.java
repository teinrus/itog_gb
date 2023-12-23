package com.example;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal("Whiskers", "cat", "2019-05-15");
        cat.addCommand("Sit");
        cat.addCommand("Pounce");

        Animal dog = new Animal("Fido", "dog", "2020-01-01");
        dog.addCommand("Sit");
        dog.addCommand("Stay");

        Animal horse = new Animal("Thunder", "horse", "2015-07-21");

        Animal.displayTotalAnimalsCount(); // Вывод общего количества животных
        Animal.displayDomesticAnimalsCount(); // Вывод количества домашних животных
        Animal.displayPackAnimalsCount(); // Вывод количества вьючных животных
    }
}
