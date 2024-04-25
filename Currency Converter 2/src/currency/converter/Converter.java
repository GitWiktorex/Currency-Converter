package currency.converter;

public class Converter extends Currency {
    public Converter(String currIn, String currOut, double amount) {
        super(currIn, currOut, amount);
    }
    
     public double ConvertAmount() {
        double exchangeRate = ReadFile.GetValueByKey(currIn+"-"+currOut);
        double convertAmount = getAmount()*exchangeRate;
        return convertAmount;
    }
}
