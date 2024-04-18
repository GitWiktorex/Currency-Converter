package currency.converter;

import java.util.Scanner;

class Convert extends ControlPanel {
    public static void OptionConvertCurr() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Podaj walute wejsciowa: ");
        String currIn = scanner.nextLine();

        System.out.print("Podaj walute wyjsciowa: ");
        String currOut = scanner.nextLine();

        System.out.print("Podaj kwote: ");
        double amount=0;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.print('\n');
            System.out.println("Niepoprawny format kwoty");
            return;
        }
        
        System.out.print(amount);   
    }
}
