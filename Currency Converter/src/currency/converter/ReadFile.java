package currency.converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ReadFile extends ControlPanel {
    private static String filename = "currency_exchange.txt"; // Nazwa pliku
    
    public static String getFilename() {
        return filename;
    }
    
    public static void PrintCurr(Map<String, String> dataMap) {
        // Wyświetlenie danych
        for(Map.Entry<String, String> entry : dataMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static Map<String, String> readDataFromFile() {
        // Wczytanie danych z pliku
        Map<String, String> dataMap = new HashMap<>();
        try {
            File file = new File(filename);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split("-"); // Dzieli linię na części po "-"
                    if (parts.length == 3) {
                        String key = parts[0] + "-" + parts[1]; // Dwie pierwsze części to klucz
                        String value = parts[2]; // Trzecia część to wartość
                        dataMap.put(key, value);
                    } else {
                        System.out.println("Nieprawidłowy format wiersza: " + line);
                    }
                }
            }
        } catch (FileNotFoundException error) {
            System.out.println("Nie znaleziono pliku ");
        }
        return dataMap;
    }
    
    public static String getValueByKey(String key, Map<String, String> dataMap) {
        return dataMap.get(key); // Pobranie wartości na podstawie klucza
    }
}
