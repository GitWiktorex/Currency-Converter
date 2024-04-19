package currency.converter;

import java.text.DecimalFormat;
import java.util.Map;

class Convert extends ControlPanel {
//    public static void OptionConvertCurr() {
//        Scanner scanner = new Scanner(System.in);
//        
//        System.out.print("Podaj walute wejsciowa: ");
//        String currIn = scanner.nextLine();
//
//        System.out.print("Podaj walute wyjsciowa: ");
//        String currOut = scanner.nextLine();
//
//        System.out.print("Podaj kwote: ");
//        double amount=0;
//        try {
//            amount = Double.parseDouble(scanner.nextLine());
//        } catch (NumberFormatException error) {
//            System.out.print('\n');
//            System.out.println("Niepoprawny format kwoty");
//            return;
//        }
//        
//        System.out.print(amount);   
//    }
    
    public void ConvertCurr() {
        Map<String, String> dataMap = ReadFile.readDataFromFile();
        
        DecimalFormat rounding = new DecimalFormat("#.00");
        
        String key = currIn + "-" + currOut;
        double value;
        
        if (dataMap.containsKey(key)) {
            value = Double.parseDouble(ReadFile.getValueByKey(key, dataMap));
            double convertedValue = amount/value;   
            System.out.println("\n" + rounding.format(amount) + " " + currIn + " to " + rounding.format(convertedValue) + " " + currOut);
        } else {
           System.out.println('\n'+"Nie mozna odnalezc kursu wymiany dla podanych walut.");   
        }
    }
}