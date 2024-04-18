package currency.converter;

import java.util.Map;
import java.util.Scanner;

public class ControlPanel {
    public static String currIn, currOut, option;
    public static double amount;

    private static void Menu() {
        System.out.println("OPCJE");
        System.out.println("1. Przeliczanie walut");
        System.out.println("2. Aktualne kursy");
        System.out.println("3. Dodanie lub modyfikacja kursu wymiany");
        System.out.println("4. Zamknij program");
        System.out.print('\n' + "Wybierz opcje: ");
    }
    
    private static void Continue(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print('\n');
        System.out.print("Nacisnij Enter, aby kontynuowac...");
        scanner.nextLine();
        System.out.print('\n');
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu();
            option = scanner.nextLine();
            System.out.print('\n');

            switch (option) {
                case "1":
                    System.out.print("Podaj walute wejsciowa: ");
                    currIn = scanner.nextLine();

                    System.out.print("Podaj walute wyjsciowa: ");
                    currOut = scanner.nextLine();

                    System.out.print("Podaj kwote: ");
                    amount=0;
                    try {
                        amount = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException error) {
                        System.out.print('\n');
                        System.out.println("Niepoprawny format kwoty");
                        return;
                    }
                    
//                    double result=Convert.ConvertCurr();
//                    System.out.print(result);
                    Convert converter = new Convert();
                    converter.ConvertCurr();
                    
                    Continue();
                    break;
                    
                case "2":
                    Map<String, String> dataMap = ReadFile.readDataFromFile(); // Wywołanie funkcji do odczytu danych z pliku
                    
                    System.out.println("AKTUALNE KURSY WALUT");
                    ReadFile.OptionPrintCurr(dataMap); // Wyświetlenie zawartości mapy
                    Continue();
                    break;
                    
                case "3":
                    System.out.println("Dodawanie/modyfikacja kursu wymiany");
                    Continue();
                    break;
                    
                case "4":
                    System.out.println("Zakonczenie pracy.");
                    return;
                    
                default:
                    System.out.println("Niepoprawna opcja.");
                    System.out.print('\n');
                    break;
            }
        }
    }  
}
