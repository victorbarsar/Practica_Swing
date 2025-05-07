package view.console;

import model.validations.UserDataValidations;
import model.exceptions.InvalidNameException;
import model.exceptions.InvalidEmailException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("\nMenú de validaciones:");
            System.out.println("1. Validar ID");
            System.out.println("2. Validar fecha");
            System.out.println("3. Calcular edad");
            System.out.println("4. Validar código postal");
            System.out.println("5. Validar número");
            System.out.println("6. Validar texto");
            System.out.println("7. Validar email");
            System.out.println("8. Validar nombre");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (option) {
                    case 1:
                        System.out.print("Ingresa el ID: ");
                        System.out.println(UserDataValidations.checkId(1, scanner.nextLine()) ? "Válido" : "Inválido");
                        break;
                    case 2:
                        System.out.print("Ingresa la fecha (dd/MM/yyyy): ");
                        System.out.println(UserDataValidations.checkFormatDate(scanner.nextLine()) ? "Válido" : "Inválido");
                        break;
                    case 3:
                        System.out.print("Ingresa la fecha de nacimiento (dd/MM/yyyy): ");
                        System.out.println("Edad: " + UserDataValidations.calculateAge(scanner.nextLine()));
                        break;
                    case 4:
                        System.out.print("Ingresa código postal: ");
                        System.out.println(UserDataValidations.checkPostalCode(scanner.nextLine()) ? "Válido" : "Inválido");
                        break;
                    case 5:
                        System.out.print("Ingrese un número: ");
                        System.out.println(UserDataValidations.isNumeric(scanner.nextLine()) ? "Válido" : "Inválido");
                        break;
                    case 6:
                        System.out.print("Ingrese un texto: ");
                        System.out.println(UserDataValidations.isAlphabetic(scanner.nextLine()) ? "Válido" : "Inválido");
                        break;
                    case 7:
                        System.out.print("Ingrese email: ");
                        try {
                            UserDataValidations.checkEmail(scanner.nextLine());
                            System.out.println("Válido");
                        } catch (InvalidEmailException e) {
                            System.out.println("Inválido: " + e.getMessage());
                        }
                        break;
                    case 8:
                        System.out.print("Ingrese nombre: ");
                        try {
                            UserDataValidations.checkName(scanner.nextLine());
                            System.out.println("Válido");
                        } catch (InvalidNameException e) {
                            System.out.println("Inválido: " + e.getMessage());
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 0);
        scanner.close();
    }
}