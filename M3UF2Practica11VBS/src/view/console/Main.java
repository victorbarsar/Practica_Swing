/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import model.validations.UserDataValidations; //Estoy importando la librería de funciones que hemos creado

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Menú de validaciones:");
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

            switch (option) {
                case 1:
                    System.out.print("Ingresa el ID: ");
                    System.out.println(UserDataValidations.checkId(1, scanner.nextLine()));
                    break;
                case 2:
                    System.out.print("Ingresa la fecha (dd/MM/yyyy): ");
                    System.out.println(UserDataValidations.checkFormatDate(scanner.nextLine()));
                    break;
                case 3:
                    System.out.print("Ingresa la fecha de nacimiento (dd/MM/yyyy): ");
                    System.out.println(UserDataValidations.calculateAge(scanner.nextLine()));
                    break;
                case 4:
                    System.out.print("Ingresa código postal: ");
                    System.out.println(UserDataValidations.checkPostalCode(scanner.nextLine()));
                    break;
                case 5:
                    System.out.print("Ingrese un número: ");
                    System.out.println(UserDataValidations.isNumeric(scanner.nextLine()));
                    break;
                case 6:
                    System.out.print("Ingrese un texto: ");
                    System.out.println(UserDataValidations.isAlphabetic(scanner.nextLine()));
                    break;
                case 7:
                    System.out.print("Ingrese email: ");
                    System.out.println(UserDataValidations.checkEmail(scanner.nextLine()));
                    break;
                case 8:
                    System.out.print("Ingrese nombre: ");
                    System.out.println(UserDataValidations.checkName(scanner.nextLine()));
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (option != 0);
        scanner.close();
    }
}