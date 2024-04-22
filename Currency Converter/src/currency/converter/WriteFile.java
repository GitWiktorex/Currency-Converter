package currency.converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class WriteFile extends ControlPanel {
    private static String filename = ReadFile.getFilename(); // Pobiera nazwe pliku

    // Metoda do zapisywania kursów walut do pliku
    private static void EditExchangeRate() {
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
            
            // Jeśli nie, to dodaje dane
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
                System.out.println("Wystapil problem podczas zapisu do pliku: " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie mozna odnalezc pliku zapisu.");
        }
    }
    
    private static void DeleteExchangeRate() {
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
            System.out.print('\n');
        } catch (IOException e) {
            System.out.println("Blad podczas przetwarzania pliku" + e.getMessage());
            return;
        }

        // Weryfikacja wykonania operacji
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Czy napewno chcesz usunac dany kurs?: ");
        String verification=scanner.nextLine();
        
        if(verification.equalsIgnoreCase("Tak")) {
            System.out.println("Usunieto wybrany kurs walut.");
            
            // Zamiana plików
            if (!oldFile.delete()) {
            System.out.println("Nie udalo się usunac pliku.");
            return;
            }
            if (!newFile.renameTo(oldFile)) {
                System.out.println("Nie udalo sie zmienic nazwy pliku.");
            }
       }
        else {
            newFile.delete();
            System.out.println("Operacja zostala anulowana.");
        }
    }
    
    public static void ResultExchangeRate(String operation) {
        if (operation ==  "edit") {
            EditExchangeRate();
        }
        else if (operation == "delete") {
            DeleteExchangeRate();
        }
        else {
            System.out.println("Nie poprawna operacja");
        }
    }
}