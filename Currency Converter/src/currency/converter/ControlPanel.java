package currency.converter;

import java.util.Scanner;

public class ControlPanel {
    protected static String currIn, currOut;
    protected static double amount, exchangeRate;
    private static String option;
    
    protected static ReadFile reader = new ReadFile("currency_exchange.txt"); // Nazwa pliku
    private static Convert converter = new Convert();

    private static void Menu() {
        System.out.println("OPCJE");
        System.out.println("1. Przeliczanie walut");
        System.out.println("2. Aktualne kursy wymiany walut");
        System.out.println("3. Dodawanie lub aktualizacja kursu wymiany walut");
        System.out.println("4. Usuwanie kursu wymiany walut");
        System.out.println("5. Wyczysc ekran konsoli");
        System.out.println("6. Zamknij program");
        System.out.print('\n' + "Wybierz opcje: ");
    }
    
    private static void Continue(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print('\n');
        System.out.print("Nacisnij Enter, aby kontynuowac...");
        scanner.nextLine();
        System.out.print('\n');
    }
    
    private static void ClearConsole() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu();
            option = scanner.nextLine();
            System.out.print('\n');

            switch (option) {
                case "1":
                    System.out.println("PRZELICZNIK WALUT");
                    
                    System.out.print("Podaj walute wejsciowa: ");
                    currIn = scanner.nextLine().toUpperCase();

                    System.out.print("Podaj walute wyjsciowa: ");
                    currOut = scanner.nextLine().toUpperCase();

                    System.out.print("Podaj kwote: ");
                    try {
                        amount = Double.parseDouble(scanner.nextLine());
                        converter.PrintConvertedAmount(); // Wyrzucenie wyniku wymiany walut
                    } 
                    catch (NumberFormatException error) {
                        System.out.print('\n');
                        System.out.println("Niepoprawny format kwoty");
                    }

                    Continue();
                    break;
                    
                case "2":
                    System.out.println("AKTUALNE KURSY WALUT");
                    reader.PrintCurr(); // Wyświetlenie zawartości mapy
                    Continue();
                    break;
                    
                case "3":
                    System.out.println("EDYTOWANIE KURSU WYMIANY WALUT");
                    
                    System.out.print("Podaj walute wejsciowa: ");
                    currIn = scanner.nextLine().toUpperCase();

                    System.out.print("Podaj walute wyjsciowa: ");
                    currOut = scanner.nextLine().toUpperCase();

                    System.out.print("Podaj kurs wymiany: ");
                    try {
                        exchangeRate = Double.parseDouble(scanner.nextLine());
                        WriteFile.ResultExchangeRate("edit");
                    } 
                    catch (NumberFormatException error) {
                        System.out.print('\n');
                        System.out.println("Niepoprawny format kursu");
                    }
                    Continue();
                    break;
                    
                case "4":
                    System.out.println("USUWANIE KURSU WYMIANY WALUT");
                    
                    System.out.print("Podaj walute wejsciowa: ");
                    currIn = scanner.nextLine().toUpperCase();

                    System.out.print("Podaj walute wyjsciowa: ");
                    currOut = scanner.nextLine().toUpperCase();
                    
                    WriteFile.ResultExchangeRate("delete");
                    Continue();
                    break;
                
                case "5":
                    ClearConsole();
                    break;
                    
                case "6":
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
