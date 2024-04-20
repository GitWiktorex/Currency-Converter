package currency.converter;

import java.text.DecimalFormat;
import java.util.Map;

class Convert extends ControlPanel {
    
    private double ConvertCurr(String key) {
        Map<String, String> dataMap = ReadFile.readDataFromFile(); // Wywołanie funkcji do odczytu danych z pliku

        double value;
        double convertedValue=-1;
        
        // Sprawdzenie czy podany klucz istnieje i zwrocenie jego wartości
        if (dataMap.containsKey(key)) {
            value = Double.parseDouble(ReadFile.getValueByKey(key, dataMap));
            convertedValue = amount/value;   
            return convertedValue;
        }
        else {
            return convertedValue;
        } 
        
    }
    
     public void PrintConvertedAmount(){
       String key = currIn + "-" + currOut;
       double convertedAmount = ConvertCurr(key);
       
       if (convertedAmount != -1){
            DecimalFormat rounding = new DecimalFormat("0.00");
            System.out.println('\n');
            System.out.println(rounding.format(amount) + " " + currIn + " to " + rounding.format(convertedAmount) + " " + currOut);
       }
       else {
            System.out.println('\n'+"Nie mozna odnalezc kursu wymiany dla podanych walut."); 
       }              
    }
}