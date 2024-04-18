package currency.converter;

import java.util.Scanner;

public class ControlPanel {

    public static void Menu() {
        System.out.println("OPCJE");
        System.out.println("1. Przeliczanie walut");
        System.out.println("2. Pokaz aktualne kursy");
        System.out.println("3. Dodanie lub modyfikacja kursu wymiany");
        System.out.println("4. Zamknij program");
        System.out.print('\n' + "Wybierz opcje: ");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu();
            String opcja = scanner.nextLine();

            switch (opcja) {
                case "1":
//                  Convert.OptionConverCura(scanner);
                    System.out.print('\n');
                    break;
                case "2":
//                  Map<String, String> dataMap = ReadFile.readDataFromFile("kursy.txt"); // Wywołanie funkcji do odczytu danych z pliku
//                  ReadFile.OptionPrintCura(dataMap); // Wyświetlenie zawartości mapy
                    System.out.print('\n');
                    break;
                case "3":
                    System.out.println("Dodawanie/modyfikacja kursu wymiany");
                    System.out.print('\n');
                    break;
                case "4":
                    System.out.println("Zakonczenie pracy");
                    return;
                default:
                    System.out.println("Niepoprawna opcja.");
                    System.out.print('\n');
                    break;
            }
        }
    }  
}
