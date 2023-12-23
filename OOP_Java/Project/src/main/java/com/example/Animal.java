package com.example;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private static int totalAnimals = 0; // Счетчик всех животных
    private static int domesticAnimals = 0; // Счетчик домашних животных
    private static int packAnimals = 0; // Счетчик вьючных животных

    private String name;
    private String type;
    private String birthDate;
    private List<String> commands;

    public Animal(String name, String type, String birthDate) {
        this.name = name;
        this.type = type;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();

        totalAnimals++; // Увеличиваем счетчик всех животных
        if (isDomesticAnimal(type)) {
            domesticAnimals++; // Увеличиваем счетчик домашних животных
        } else {
            packAnimals++; // Увеличиваем счетчик вьючных животных
        }
    }

    private boolean isDomesticAnimal(String type) {
        String[] domesticTypes = {"dog", "cat", "hamster"}; // Типы домашних животных
        for (String domesticType : domesticTypes) {
            if (type.equalsIgnoreCase(domesticType)) {
                return true;
            }
        }
        return false;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void listCommands() {
        if (commands.isEmpty()) {
            System.out.println("No commands available for " + name);
        } else {
            System.out.println("Commands for " + name + ":");
            for (String command : commands) {
                System.out.println("- " + command);
            }
        }
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }

    public static void displayTotalAnimalsCount() {
        System.out.println("Total animals: " + totalAnimals);
    }

    public static void displayDomesticAnimalsCount() {
        System.out.println("Domestic animals: " + domesticAnimals);
    }

    public static void displayPackAnimalsCount() {
        System.out.println("Pack animals: " + packAnimals);
    }
    

}
