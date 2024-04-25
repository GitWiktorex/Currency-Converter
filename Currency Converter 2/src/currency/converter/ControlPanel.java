package currency.converter;

import java.util.Scanner;

public class ControlPanel{
    protected static String currIn, currOut;
    protected static double amount, exchangeRate;
    private static String option;

    private static void Menu() {
        System.out.println("OPCJE");
        System.out.println("1. Przeliczanie walut");
//        System.out.println("2. Aktualne kursy wymiany walut");
//        System.out.println("3. Dodawanie lub aktualizacja kursu wymiany walut");
//        System.out.println("4. Usuwanie kursu wymiany walut");
//        System.out.println("5. Wyczysc ekran konsoli");
//        System.out.println("6. Zmiana pliku zrodlowego z danymi");
        System.out.println("7. Zamknij program");
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
                    Converter pln = new Converter("PLN", "EUR", 1);
                    Converter eur = new Converter("EUR", "PLN", 1);
                    
                    System.out.println("1 PLN to: " + pln.ConvertAmount() + " EUR");
                    System.out.println("4.23 EUR to: " + eur.ConvertAmount() + " PLN");
                    break;
                    
                case "2":
                    System.out.println("AKTUALNE KURSY WALUT");
                   
                        break;
                    
                case "3":
                    System.out.println("EDYTOWANIE KURSU WYMIANY WALUT");
                    
                    break;
                    
                case "4":
                    System.out.println("USUWANIE KURSU WYMIANY WALUT");
                    
                    break;
                
                case "5":
                    ClearConsole();
                    break;
                    
                case "6":
                    System.out.println("ZMAIAN PLIKU Z KURSAMI WYMIANY WALUT");
                    
                    break;
                    
                case "7":
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
