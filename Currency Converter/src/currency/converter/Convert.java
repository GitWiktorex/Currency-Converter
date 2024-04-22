package currency.converter;

import java.text.DecimalFormat;

class Convert extends ControlPanel {
    private String key;
    private double value;
    private double convertedAmount;

    private double ConvertCurr(String key) {
        value = ReadFile.getValueByKey(key);
        
        if(value != 0) {
            convertedAmount = amount/value; 
            return convertedAmount; 
        }
        else {
            return -1;
        }
    }
    
     public void PrintConvertedAmount(){
       key = currIn + "-" + currOut;
       convertedAmount = ConvertCurr(key);
       
       if (convertedAmount != -1){
            DecimalFormat rounding = new DecimalFormat("0.00");
            
            System.out.print('\n');
            System.out.println(rounding.format(amount) + " " + currIn + " to " + rounding.format(convertedAmount) + " " + currOut);
       }
       else {
            System.out.println('\n'+"Nie mozna odnalezc kursu wymiany dla podanych walut."); 
       }              
    }
}