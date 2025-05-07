package model.validations;

import model.exceptions.InvalidNameException;
import model.exceptions.InvalidEmailException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;

public class UserDataValidations {
    
    public static boolean checkId(int typeDoc, String id) {
        if (typeDoc != 1) return false;
        return id.matches("\\d{8}[A-HJ-NP-TV-Z]");
    }
    
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
    
    public static int calculateAge(String birthDate) {
        if (!checkFormatDate(birthDate)) return -1;
        LocalDate birth = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return Period.between(birth, LocalDate.now()).getYears();
    }
    
    public static boolean checkPostalCode(String zip) {
        return zip.matches("\\d{5}");
    }
    
    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
    
    public static boolean isAlphabetic(String str) {
        return str.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }
    
    public static void checkEmail(String email) throws InvalidEmailException {
        if (!email.contains("@")) {
            throw new InvalidEmailException("El email debe contener @");
        }
    }
    
    public static void checkName(String name) throws InvalidNameException {
        if (!name.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new InvalidNameException("El nombre solo debe contener letras");
        }
        if (name.length() < 2 || name.length() > 50) {
            throw new InvalidNameException("El nombre debe tener entre 2 y 50 caracteres");
        }
    }
}