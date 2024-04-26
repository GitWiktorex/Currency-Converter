package currency.converter;

abstract class Currency {
    protected String currIn;
    protected String currOut;
    
    public Currency(String currIn, String currOut) {
        this.currIn = currIn;
        this.currOut = currOut;
    }
    
    public abstract double ConvertAmount(double amount);
}