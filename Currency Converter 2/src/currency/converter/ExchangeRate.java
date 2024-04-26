package currency.converter;

class ExchangeRate extends Currency {
    private double amount;
    private  double exchangeRate;
    private double convertedAmount;
    
    public ExchangeRate(String currIn, String currOut, double amount) {
        super(currIn, currOut);
        this.amount = amount;
    }
    
    @Override
     public double ConvertAmount() {
        exchangeRate = ReadFile.GetValue(Key());
        convertedAmount = amount*exchangeRate;
        return convertedAmount;
    }
}
