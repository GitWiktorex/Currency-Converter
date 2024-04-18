package currency.converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ReadFile extends ControlPanel {
    private static String filename = "CurrData.txt"; // Nazwa pliku
    
    public static void OptionPrintCurr(Map<String, String> dataMap) {
        // Wyświetlenie danych
        for(Map.Entry<String, String> entry : dataMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static Map<String, String> readDataFromFile() {
        Map<String, String> dataMap = new HashMap<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("-"); // Dzieli linię na części po "-"
                if (parts.length == 3) { // Upewnij się, że mamy trzy części (klucz-wartość)
                    String key = parts[0] + "-" + parts[1]; // Łączy dwie pierwsze części jako klucz
                    String value = parts[2]; // Trzecia część jako wartość
                    dataMap.put(key, value);
                } else {
                    System.out.println("Nieprawidłowy format wiersza: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku ");
            e.printStackTrace();
        }
        return dataMap;
    }
    
    public static String getValueByKey(String key, Map<String, String> dataMap) {
        return dataMap.get(key); // Pobranie wartości na podstawie klucza
    }
}
