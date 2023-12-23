package com.example;
import java.util.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AnimalRegistry {
    private List<Animal> animals;
    private Scanner scanner;

    public AnimalRegistry() {
        animals = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public void listCommands(int index) {
        if (index >= 0 && index < animals.size()) {
            animals.get(index).listCommands();
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void teachCommand(int index) {
        if (index >= 0 && index < animals.size()) {
            System.out.println("Enter new command for " + animals.get(index).getName() + ":");
            String newCommand = scanner.nextLine();
            animals.get(index).addCommand(newCommand);
            System.out.println("Command added successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void listAnimalsByBirthDate() {
        animals.stream()
                .sorted(Comparator.comparing(Animal::getBirthDate))
                .forEach(animal -> System.out.println(animal.getName() + ": " + animal.getBirthDate()));
    }

    public void showMenu() {
        System.out.println("Animal Registry Menu:");
        System.out.println("1. Add new animal");
        System.out.println("2. List commands for an animal");
        System.out.println("3. Teach new command to an animal");
        System.out.println("4. List animals by birth date");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        int choice;

        do {
            registry.showMenu();
            System.out.println("Enter your choice:");
            choice = Integer.parseInt(registry.scanner.nextLine());

            switch (choice) {
                case 1:
                    registry.addAnimal();
                    break;
                case 2:
                    System.out.println("Enter the index of the animal:");
                    int index = Integer.parseInt(registry.scanner.nextLine());
                    registry.listCommands(index);
                    break;
                case 3:
                    System.out.println("Enter the index of the animal to teach a new command:");
                    int idx = Integer.parseInt(registry.scanner.nextLine());
                    registry.teachCommand(idx);
                    break;
                case 4:
                    registry.listAnimalsByBirthDate();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 5);
    }
}