package currency.converter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class WriteFile extends ControlPanel {
    private static String filename = "currency_exchange.txt"; //ReadFile.getFilename();

    // Metoda do zapisywania kursów walut do pliku
    static void addOrUpdateExchangeRate() {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            StringBuilder fileContent = new StringBuilder();

            // Odczytanie zawartości pliku
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Sprawdzenie, czy dane już istnieją w pliku
                if (line.startsWith(currIn + "-" + currOut)) {
                    // Jeśli tak, to aktualizujemy dane
                    line = currIn + "-" + currOut + "-" + exchangeRate;
                }
                fileContent.append(line).append("\n");
            }
            scanner.close();

            // Zapisanie nowej zawartości pliku (uwzględniając ewentualną aktualizację)
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                writer.write(fileContent.toString());
                writer.flush();
                System.out.println("Dodano lub zaktualizowano kurs wymiany.");
            } catch (IOException e) {
                System.out.println("Wystąpił problem podczas zapisu do pliku: " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie mozna odnalezc pliku zapisu");
        }
    }
}
