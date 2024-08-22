package ConverterPoundsKg;

import java.util.Scanner;
/**
 * Un programme pour convertir les poids entre Livres (Pounds) et Kilogrammes.
 */
public class Main {
    public static void main(String[] args) {
        float kilogrammes, pounds;
        int choice = -1;
        boolean validInput;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Pounds to Kilograms Converter!");
        System.out.println("\nMenu:\n 1. Kilograms to Pounds\n 2. Pounds to Kilograms\n");

        while (choice != 1 && choice != 2) {
            choice = getUserChoice(scanner);
            switch (choice) {
                case 1:
                    kilogrammes = getWeight(scanner, "Please enter the weight in Kilograms: ");
                    pounds = kilogrammes * 2.2046f;
                    System.out.println("Weight in Pounds: " + pounds);
                    break;
                case 2:
                    pounds = getWeight(scanner, "Please enter the weight in Pounds: ");
                    kilogrammes = pounds * 0.453592f;
                    System.out.println("Weight in Kilograms: " + kilogrammes);
                    break;
                default:
                    System.out.println("Erreur : Vous avez le choix entre 1 et 2.");
                    choice = -1;
                    break;
            }
        }

        System.out.println("Merci d'avoir utilisé mon programme ;)");
        scanner.close();
    }

    /**
     * Demande à l'utilisateur de choisir une option du menu et retourne l'option choisie.
     *
     * @param scanner Objet Scanner pour lire les entrées de l'utilisateur
     * @return l'option choisie par l'utilisateur
     */
    private static int getUserChoice(Scanner scanner) {
        int choice = -1;
        try {
            System.out.print("Choix : ");
            choice = scanner.nextInt();
        } catch (Exception e) {
            scanner.next();
        }
        return choice;
    }
    /**
     * Demande à l'utilisateur d'entrer un poids et valide l'entrée.
     *
     * @param scanner Objet Scanner pour lire les entrées de l'utilisateur
     * @param prompt  Le message pour demander à l'utilisateur
     * @return le poids valide entré par l'utilisateur
     */
    private static float getWeight(Scanner scanner, String prompt) {
        float weight = 0;
        boolean validInput = false;
        do {
            System.out.print(prompt);
            try {
                weight = scanner.nextFloat();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Erreur : Il faut un chiffre.");
                scanner.next();
            }
        } while (!validInput);
        return weight;
    }
}
