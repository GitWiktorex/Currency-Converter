package currency.converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class WriteFile {
    private static String filename = ReadFile.filename; // Pobiera nazwe pliku

    // Metoda zapisująca kursy walut do pliku
    public static void EditExchangeRate(String currIn, String currOut, double exchangeRate) {
        boolean found;
        try {
            File file = new File(filename);
            StringBuilder fileContent;
            
            try (Scanner scanner = new Scanner(file)) {
                fileContent = new StringBuilder();
                found = false;
                
                // Odczytanie zawartości pliku
                while (scanner.hasNextLine()) {
                    String updateExchangeRate = scanner.nextLine();
                    
                    // Sprawdzenie, czy dane już istnieją w pliku
                    if (updateExchangeRate.startsWith(currIn + "-" + currOut)) {
                        
                        // Jeśli tak, to aktualizujemy dane
                        updateExchangeRate = currIn + "-" + currOut + "-" + exchangeRate;
                        found = true;
                    }
                    fileContent.append(updateExchangeRate).append("\n");
                }
                
                if(found){
                    System.out.print('\n');
                    System.out.println("Zaktualizowano kurs wymiany walut.");
                }
            }
            
            // Jeśli nie, to dodaje nowy kurs
            if(!found) {
                String newExchangeRate = currIn + "-" + currOut + "-" + exchangeRate;
                fileContent.append(newExchangeRate).append("\n");
                
                System.out.print('\n');
                System.out.println("Dodano nowy kurs wymiany walut.");
            }

            // Zapisanie nowej zawartości pliku (uwzględniając ewentualną aktualizację)
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                writer.write(fileContent.toString());
                writer.flush();
            } catch (IOException e) {
                System.out.print('\n');
                System.out.println("Wystapil problem podczas zapisu do pliku: " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.print('\n');
            System.out.println("Nie mozna odnalezc pliku zapisu.");
        }
    }
    
    public static void DeleteExchangeRate(String currIn, String currOut) {
        File oldFile = new File(filename);
        File newFile = new File("temp_" + filename);
        

        try (BufferedReader reader = new BufferedReader(new FileReader(oldFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
            
            String exchangeRate;
            while ((exchangeRate = reader.readLine()) != null) {
                // Sprawdza, czy linia zawiera usuwany kurs, jeśli nie zapisuje ją do nowego pliku
                if (!exchangeRate.contains(currIn + "-" + currOut)) {
                    writer.write(exchangeRate + System.getProperty("line.separator"));
                }
            }
        } catch (IOException e) {
            System.out.print('\n');
            System.out.println("Blad podczas przetwarzania pliku" + e.getMessage());
            return;
        }

        // Weryfikacja wykonania operacji
        Scanner scanner = new Scanner(System.in);
        
        System.out.print('\n');
        System.out.print("Czy napewno chcesz usunac dany kurs?: ");
        String verification=scanner.nextLine();
        
        if(verification.equalsIgnoreCase("Tak")) {
            System.out.println("Usunieto wybrany kurs walut.");
            
            // Zamiana plików
            if (!oldFile.delete()) {
                System.out.print('\n');
            System.out.println("Nie udalo się usunac pliku.");
            return;
            }
            if (!newFile.renameTo(oldFile)) {
                System.out.print('\n');
                System.out.println("Nie udalo sie zmienic nazwy pliku.");
            }
       }
        else {
            newFile.delete();
            System.out.println("Operacja zostala anulowana.");
        }
    }
}