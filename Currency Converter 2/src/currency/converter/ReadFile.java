package currency.converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ReadFile  {
    public static String filename = "exchange_rates.txt";
    
    public ReadFile(String filename) {
        this.filename = filename;
    }
    
    private static Map<String, String> ReadDataFromFile() {
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
            System.out.print('\n');
            System.out.println("Nie znaleziono pliku. ");
        }
        return dataMap;
    }
    
    public static void PrintCurr() {
        // Wywołanie funkcji do odczytu danych z pliku
        Map<String, String> dataMap = ReadDataFromFile();
        
        // Wyświetlenie danych
        for(Map.Entry<String, String> entry : dataMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public static double GetValue(String key) {
        // Wywołanie funkcji do odczytu danych z pliku
        Map<String, String> dataMap = ReadDataFromFile();
        
        // Sprawdzenie czy podany klucz istnieje i zwrocenie jego wartości
        if (dataMap.containsKey(key)) {
            return Double.parseDouble(dataMap.get(key)); // Zmiana typu na double
        }
        else {
            return 0;
        } 
        
    }
    
    public static void NewFile(String newFilename){
        if(newFilename != "") {
            ReadFile readFile = new ReadFile(newFilename);
            System.out.print('\n');
            System.out.println("Plik zrodlowy z danymi zostal zmieniony, kursy beda pobierane z pliku: " + newFilename);
        }
        else {
            System.out.print('\n');
            System.out.println("Plik zrodlowy z danymi nie zostal zmieniony, kursy beda pobierane z pliku: " + filename);
        }
    }
}