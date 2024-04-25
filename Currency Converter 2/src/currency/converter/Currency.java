package currency.converter;

public class Currency {
    protected String currIn;
    protected String currOut;
    private double amount;
    
    public Currency(String currIn, String currOut, double amount) {
        this.currIn = currIn;
        this.currOut = currOut;
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }
}