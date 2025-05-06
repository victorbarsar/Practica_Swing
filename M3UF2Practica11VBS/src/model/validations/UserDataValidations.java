/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
// --- Paquete model.validations ---
package model.validations;

import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;

public class UserDataValidations {
    //Valida si el ID es un NIF correcto.
    
    public static boolean checkId(int typeDoc, String id) {
        if (typeDoc != 1) return false;
        return id.matches("\\d{8}[A-HJ-NP-TV-Z]");
    }
    
    //Valida el formato de la fecha dd/MM/yyyy.
     
    public static boolean checkFormatDate(String date) {
        String[] parts = date.split("/");
        if (parts.length != 3) return false;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    // Calcula la edad a partir de la fecha de nacimiento.
    
    public static int calculateAge(String birthDate) {
        if (!checkFormatDate(birthDate)) return -1;
        LocalDate birth = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return Period.between(birth, LocalDate.now()).getYears();
    }
    
    
     //Valida un código postal de 5 dígitos.
     
    public static boolean checkPostalCode(String zip) {
        return zip.matches("\\d{5}");
    }
    
    // Comprueba si una cadena es numérica.
     
    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
    
    // Comprueba si una cadena es alfabética.
    
    public static boolean isAlphabetic(String str) {
        return str.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }
    
    // Valida un correo electrónico.
     
    public static boolean checkEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$");
    }
    
    //Valida un nombre sin números y con longitud lógica.
     
    public static boolean checkName(String name) {
        return name.length() >= 2 && name.length() <= 50 && isAlphabetic(name);
    }
}
