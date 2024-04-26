package currency.converter;

public class ExchangeRate extends Currency {
    private  double exchangeRate;
    private double convertedAmount;
    
    public ExchangeRate(String currIn, String currOut) {
        super(currIn, currOut);
    }
    
    @Override
     public double ConvertAmount(double amount) {
        exchangeRate = ReadFile.GetValueByKey(currIn+"-"+currOut);
        convertedAmount = amount*exchangeRate;
        return convertedAmount;
    }
}
