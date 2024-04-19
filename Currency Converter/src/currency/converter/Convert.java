package currency.converter;

import java.text.DecimalFormat;
import java.util.Map;

class Convert extends ControlPanel {
    
    private double ConvertCurr(String key) {
        Map<String, String> dataMap = ReadFile.readDataFromFile();

        double value;
        double convertedValue=0;
        
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
       
       if (convertedAmount != 0){
            DecimalFormat rounding = new DecimalFormat("#.00");
            System.out.println("\n" + rounding.format(amount) + " " + currIn + " to " + rounding.format(convertedAmount) + " " + currOut);
       }
       else {
            System.out.println('\n'+"Nie mozna odnalezc kursu wymiany dla podanych walut."); 
       }              
    }
}