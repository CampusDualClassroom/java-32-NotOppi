package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise32 {

    public static void main(String[] args) {
        String textToSave = generateStringToSave(null);
        printToFile(textToSave);
        System.out.println("Text has been saved to src/main/resources/data.txt");
    }

    public static String generateStringToSave(String string) {
        if (string == null) {
            return generateUserInputToSave();
        }
        return string;
    }

    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while(!(string = Utils.string()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        File directory = new File("src/main/resources");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/data.txt"))) {
            writer.write(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}