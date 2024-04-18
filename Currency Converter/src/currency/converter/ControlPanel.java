package currency.converter;

import java.util.Map;
import java.util.Scanner;

public class ControlPanel {

    public static void Menu() {
        System.out.println("OPCJE");
        System.out.println("1. Przeliczanie walut");
        System.out.println("2. Aktualne kursy");
        System.out.println("3. Dodanie lub modyfikacja kursu wymiany");
        System.out.println("4. Zamknij program");
        System.out.print('\n' + "Wybierz opcje: ");
    }
    
    public static void Continue(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print('\n');
        System.out.println("Nacisnij Enter, aby kontynuowac...");
        scanner.nextLine();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu();
            int option = scanner.nextInt();
            System.out.print('\n');

            switch (option) {
                case 1:
                    Convert.OptionConvertCurr();  
                    Continue();
                    break;
                case 2:
                    Map<String, String> dataMap = ReadFile.readDataFromFile(); // Wywołanie funkcji do odczytu danych z pliku
                    
                    System.out.println("AKTUALNE KURSY WALUT");
                    ReadFile.OptionPrintCurr(dataMap); // Wyświetlenie zawartości mapy
                    Continue();
                    break;
                case 3:
                    System.out.println("Dodawanie/modyfikacja kursu wymiany");
                    Continue();
                    break;
                case 4:
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
