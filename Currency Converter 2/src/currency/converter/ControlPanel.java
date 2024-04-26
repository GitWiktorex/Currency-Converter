package currency.converter;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ControlPanel{
    private static String currIn, currOut;
    private static double amount, exchangeRate;
    private static String option;

    private static void Menu() {
        System.out.println("OPCJE");
        System.out.println("1. Przeliczanie walut");
        System.out.println("2. Aktualne kursy wymiany walut");
        System.out.println("3. Dodawanie lub aktualizacja kursu wymiany walut");
        System.out.println("4. Usuwanie kursu wymiany walut");
        System.out.println("5. Wyczysc ekran konsoli");
        System.out.println("6. Wybierz inny plik z kursami walut");
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
                    System.out.println("PRZELICZNIK WALUT");
                    
                    System.out.print("Podaj walute wejsciowa: ");
                    currIn = scanner.nextLine().toUpperCase();

                    System.out.print("Podaj walute wyjsciowa: ");
                    currOut = scanner.nextLine().toUpperCase();
                    
                    if(currIn != "" || currOut!=""){
                        DecimalFormat rounding = new DecimalFormat("0.00"); // Zaokrąglanie wyników
                        
                        System.out.print("Podaj kwote: ");
                    try {         
                        amount = Double.parseDouble(scanner.nextLine());
                        ExchangeRate rate = new ExchangeRate(currIn, currOut);
                        System.out.print('\n');
                        System.out.println(rounding.format(amount) + " " + currIn + " to " + rounding.format(rate.ConvertAmount(amount)) + " " + currOut);
                    } 
                    catch (NumberFormatException error) {
                        System.out.print('\n');
                        System.out.println("Niepoprawny format kwoty.");
                    }
                    }
                    else {
                        System.out.print('\n');
                        System.out.println("Nie podano walut, operacja zostala anulowana.");
                    }
                    Continue();
                    break;
                    
                case "2":
                    System.out.println("AKTUALNE KURSY WALUT");
                    ReadFile.PrintCurr();
                    Continue();
                    break;
                    
                case "3":
                    System.out.println("EDYTOWANIE KURSU WYMIANY WALUT");
                    
                    System.out.print("Podaj walute wejsciowa: ");
                    currIn = scanner.nextLine().toUpperCase();

                    System.out.print("Podaj walute wyjsciowa: ");
                    currOut = scanner.nextLine().toUpperCase();

                    if(currIn != "" || currOut!=""){
                        System.out.print("Podaj kurs wymiany: ");
                        try {
                            exchangeRate = Double.parseDouble(scanner.nextLine());
                            WriteFile.EditExchangeRate(currIn, currOut, exchangeRate);
                        } 
                        catch (NumberFormatException error) {
                            System.out.print('\n');
                            System.out.println("Niepoprawny format kursu.");
                        }
                    }
                    else {
                        System.out.print('\n');
                        System.out.println("Nie podano walut, operacja zostala anulowana.");
                    }
                    Continue();
                    break;
                    
                case "4":
                    System.out.println("USUWANIE KURSU WYMIANY WALUT");
                    
                    System.out.print("Podaj walute wejsciowa: ");
                    currIn = scanner.nextLine().toUpperCase();

                    System.out.print("Podaj walute wyjsciowa: ");
                    currOut = scanner.nextLine().toUpperCase();
                    
                    if(currIn != "" && currOut!=""){
                        WriteFile.DeleteExchangeRate(currIn, currOut);
                    }
                    else {
                        System.out.print('\n');
                        System.out.println("Nie podano walut, operacja zostala anulowana.");
                    }
                    Continue();
                    break;
                
                case "5":
                    ClearConsole();
                    break;
                    
                case "6":
                    System.out.println("PLIK ZAWIERAJACY KURSY WYMIANY WALUT");
                    
                    String actualFile = ReadFile.filename;
                    String newFile;
                    
                    System.out.println("Aktualna pliku z danymi: " + actualFile);
                    System.out.print("Nowa plik z danymi: ");
                    newFile = scanner.nextLine();
                    
                    ReadFile.NewFile(newFile);
                    Continue();
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
